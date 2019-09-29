package com.keepaccountable.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.domain.Account;
import com.keepaccountable.persist.ChallengeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@SessionAttributes("token")
public class ChallengeService {

    @Autowired
    ChallengeDAO challengeDAO;

    @Autowired
    private BankEngineClient client;

    @PostMapping(path = "/challenge", consumes = "application/json", produces = "application/json")
    public ChallengeFormSubmission create(@RequestBody ChallengeFormSubmission challenge, @ModelAttribute("token") String token) {
        challengeDAO.save(challenge);
        Account account = client.getAllAccount(challenge.getToken()).get(0);
        client.depositToSafetyAccount(account, (double) challenge.getSubscriptionCap(), challenge.getToken());
        return challenge;
    }

    @GetMapping(value = "/challenge/{id}")
    public Optional<ChallengeFormSubmission> retrieve(@PathVariable("id") String id) {
        return challengeDAO.findById(id);
    }
}
