package com.keepaccountable.service;

import com.keepaccountable.domain.Token;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class BankEngineClient {

    @Autowired
    private RestTemplate restClient;

    private String authUrl = "https://auth.bankengine.nz/connect/token";


    public Token exchangeToken(@NotNull String clientId, @NotNull String secret, @NotNull String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("client_id", clientId);
        map.add("client_secret", secret);
        map.add("redirect_uri", "http://localhost:8080/callback");
        map.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<Token> result = restClient.postForEntity(authUrl, request, Token.class);
        log.info(result.getBody().toString());
        return result.getBody();
    }

    public Token refreshToken(@NotNull String clientId, @NotNull String secret, @NotNull String refreshToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("client_id", clientId);
        map.add("client_secret", secret);
        map.add("redirect_uri", "http://localhost:8080/callback");
        map.add("code", refreshToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<Token> result = restClient.postForEntity(authUrl, request, Token.class);
        log.info(result.getBody().toString());
        return result.getBody();
    }
}
