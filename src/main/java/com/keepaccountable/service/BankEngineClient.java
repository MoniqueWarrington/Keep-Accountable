package com.keepaccountable.service;

import com.keepaccountable.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class BankEngineClient {

    @Autowired
    private RestTemplate restClient;


    @Value("${bankengine.client.id}")
    private String clientId;
    @Value("${bankengine.client.secret}")
    private String clientSecret;


    public Token exchangeToken() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.TEXT_PLAIN);
//
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("grant_type", "authorization_code");
//        map.add("client_id", clientId);
//        map.add("client_secret", clientSecret);
//        map.add("redirect_uri", "http://localhost:8080/callback");
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//
//
//        restClient.postForEntity("https://auth.bankengine.nz/connect/token", request, Token.class);
        return null;
    }
}
