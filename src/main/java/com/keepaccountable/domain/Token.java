package com.keepaccountable.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Token {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expire_in")
    private String expireIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String grantType;
}
