package com.keepaccountable.service;

import com.keepaccountable.data.AccountResponse;
import com.keepaccountable.data.BalanceResponse;
import com.keepaccountable.data.TransactionResponse;
import com.keepaccountable.data.UserInfoResponse;
import com.keepaccountable.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class BankEngineClient {

    @Autowired
    private RestTemplate restClient;

    private String authUrl = "https://auth.bankengine.nz/connect/token";

    @Value("${bankengine.client.id}")
    private String clientId;

    @Value("${bankengine.client.secret}")
    private String clientSecret;

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


}
