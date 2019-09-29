package com.keepaccountable.web;

import com.keepaccountable.domain.Account;
import com.keepaccountable.domain.Token;
import com.keepaccountable.domain.UserInfo;
import com.keepaccountable.service.BankEngineClient;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class CallbackController {

    @Autowired
    private BankEngineClient client;

    @ModelAttribute("token")
    public String getToken() {
        return "token";
    }

    @GetMapping("/callback")
    public ModelAndView callback(Model model, @RequestParam("code") String code) {
        Token token = client.exchangeToken(code);
        model.addAttribute(token);

        UserInfo userInfo = client.getUserInfo(token.getAccessToken());
        if ("alainlay@gmail.com".equals(userInfo.getEmails().get(0))) {
            return new ModelAndView("callback");
        } else {
//            ModelAndView modelAndView = new ModelAndView("createChallenge");
//            modelAndView.addObject("token", token.getAccessToken());
            retriveAllInfo(code, token);
            return new ModelAndView("callback");
        }
    }

    private void retriveAllInfo(@NotNull String code, @NotNull Token token) {
//        Token token = client.exchangeToken(code);
//        UserInfo user = client.getUserInfo(token.getAccessToken());
        List<Account> accounts = client.getAllAccount(token.getAccessToken());
        accounts.forEach(account -> client.getBalance(account, token.getAccessToken()));
        accounts.forEach(account -> {
            client.getTransactions(account, token.getAccessToken()).forEach(transaction -> log.info(transaction.toString()));
        });

        client.depositToSafetyAccount(accounts.get(0), 1.66, token.getAccessToken());
        client.refundFromSafetyAccount(accounts.get(0), 2);
    }
}
