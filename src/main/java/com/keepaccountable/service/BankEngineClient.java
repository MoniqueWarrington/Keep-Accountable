package com.keepaccountable.service;

import com.keepaccountable.data.*;
import com.keepaccountable.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class BankEngineClient {

    @Autowired
    private RestTemplate restClient;

    private static String authUrl = "https://auth.bankengine.nz/connect/token";

    private static String SAFETY_ACCOUNT = "99-0129-6525632-00";

    @Value("${bankengine.client.id}")
    private String clientId;

    @Value("${bankengine.client.secret}")
    private String clientSecret;

    @Value("${safety_account_token}")
    private String safetyAccountRefreshToken;
    @Value("${sefety_account_refresh}")
    private String safetyAccountAccessToken;

    public Token exchangeToken(@NotNull String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("redirect_uri", "http://localhost:8080/callback");
        map.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<Token> result = restClient.postForEntity(authUrl, request, Token.class);
        log.info(result.getBody().toString());
        return result.getBody();
    }

    public Token refreshToken(@NotNull String refreshToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", clientId);
        map.add("client_secret", clientSecret);
        map.add("redirect_uri", "http://localhost:8080/callback");
        map.add("code", refreshToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<Token> result = restClient.postForEntity(authUrl, request, Token.class);
        log.info(result.getBody().toString());
        return result.getBody();
    }

    public UserInfo getUserInfo(@NotNull String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        ResponseEntity<UserInfoResponse> response = restClient.exchange(
                "https://api.bankengine.nz/identity/v0/userinfo",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                UserInfoResponse.class);

        log.info(response.getBody().toString());
        return response.getBody().getData().get(0);
    }


    public List<Account> getAllAccount(@NotNull String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        ResponseEntity<AccountResponse> response = restClient.exchange(
                "https://api.bankengine.nz/data/v1/accounts",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                AccountResponse.class);

        log.info(response.getBody().toString());
        return response.getBody().getData();
    }

    public Balance getBalance(@NotNull Account account, @NotNull String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        ResponseEntity<BalanceResponse> response = restClient.exchange(
                "https://api.bankengine.nz/data/v1/accounts/{account_id}/balance",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                BalanceResponse.class,
                account.getAccountId());

        log.info(response.getBody().toString());
        return response.getBody().getData().get(0);
    }

    public List<Transaction> getTransactions(@NotNull Account account, @NotNull String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        ResponseEntity<TransactionResponse> response = restClient.exchange(
                "https://api.bankengine.nz/data/v1/accounts/{account-id}/transactions",
                HttpMethod.GET,
                new HttpEntity<>(null, headers),
                TransactionResponse.class,
                account.getAccountId());

        log.info(response.getBody().toString());
        return response.getBody().getData();
    }

    public boolean makePayment(@NotNull PaymentRequest payment, @NotNull String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity response = restClient.exchange(
                "https://api.bankengine.nz/payments/v0/payment",
                HttpMethod.POST,
                new HttpEntity<>(payment, headers),
                Object.class);

        log.info(response.toString());
        return response.getStatusCode().equals(HttpStatus.OK) ? true : false;
    }

    public boolean depositToSafetyAccount(@NotNull Account fromAccount, double amount, @NotNull String accessToken) {
        String refStr = RandomStringUtils.randomAlphabetic(6);
        PaymentRequest payment = PaymentRequest.builder()
                .fromAccount(fromAccount.getAccountNumber())
                .toAccount(SAFETY_ACCOUNT)
                .from(PaymentRef.builder()
                        .particulars("safety")
                        .code("deposit")
                        .reference(refStr)
                        .build())
                .to(PaymentRef.builder()
                        .particulars("subscriber")
                        .code("income")
                        .reference(refStr)
                        .build())
                .amount(BigDecimal.valueOf(amount))
                .build();
        return makePayment(payment, accessToken);
    }

    public boolean refundFromSafetyAccount(@NotNull Account toAccount, double amount) {
        String refStr = RandomStringUtils.randomAlphabetic(6);
        PaymentRequest refund = PaymentRequest.builder()
                .fromAccount(SAFETY_ACCOUNT)
                .toAccount(toAccount.getAccountNumber())
                .from(PaymentRef.builder()
                        .particulars("safety")
                        .code("lost")
                        .reference(refStr)
                        .build())
                .to(PaymentRef.builder()
                        .particulars("subscriber")
                        .code("refund")
                        .reference(refStr)
                        .build())
                .amount(BigDecimal.valueOf(amount))
                .build();
        return makePayment(refund, safetyAccountAccessToken);
    }

}
