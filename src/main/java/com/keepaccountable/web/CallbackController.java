package com.keepaccountable.web;

import com.keepaccountable.data.PaymentRequest;
import com.keepaccountable.data.PaymentRef;
import com.keepaccountable.domain.Account;
import com.keepaccountable.domain.Token;
import com.keepaccountable.domain.UserInfo;
import com.keepaccountable.service.BankEngineClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Controller
@SessionAttributes("token")
public class CallbackController {

    @Autowired
    private BankEngineClient client;

    @ModelAttribute("token")
    public String getToken() {
        return "token";
    }

    @GetMapping("/callback")
    public ModelAndView callback(@RequestParam("code") String code, @ModelAttribute("token") String token) {
        ModelAndView modelAndView = new ModelAndView("callback");
        modelAndView.addObject("token", code);
        token = code;

        retriveAllInfo(code);
        return modelAndView;
    }

    private void retriveAllInfo(@NotNull String code) {
        Token token = client.exchangeToken(code);
        UserInfo user = client.getUserInfo(token.getAccessToken());
        List<Account> accounts = client.getAllAccount(token.getAccessToken());
        accounts.forEach(account -> client.getBalance(account, token.getAccessToken()));
        accounts.forEach(account -> {
            client.getTransactions(account, token.getAccessToken()).forEach(transaction -> log.info(transaction.toString()));
        });


        String refStr = RandomStringUtils.randomAlphabetic(6);

        PaymentRequest payment = PaymentRequest.builder()
                .fromAccount(accounts.get(0).getAccountNumber())
                .toAccount("99-0129-6525632-00")
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
                .amount(BigDecimal.valueOf(1.45))
                .build();
        client.makePayment(payment, token.getAccessToken());
    }
}
