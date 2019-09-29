package com.keepaccountable.web;

import com.keepaccountable.domain.Token;
import com.keepaccountable.service.BankEngineClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class SafetyAccountController {

    @Autowired
    private BankEngineClient bankEngineClient;

    @GetMapping("/safety_account")
    public String safety() {
        return "safety";
    }

    @GetMapping("/safety_account_auth")
    public String safetyAccountAuth(String code) {
        Token safetyToken = bankEngineClient.exchangeToken(code);
        return safetyToken.getAccessToken();
    }
}
