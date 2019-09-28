package com.keepaccountable.service;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.persist.ChallengeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ChallengeService {

    @Autowired
    ChallengeDAO challengeDAO;

    @Autowired
    private BankEngineClient client;

    @PostMapping(value = "/challenge")
    public void create(@RequestBody ChallengeFormSubmission challenge) {
        challengeDAO.save(challenge);
    }

    @GetMapping(value = "/challenge/{id}")
    public Optional<ChallengeFormSubmission> retrieve(@PathVariable("id") String id) {
        return challengeDAO.findById(id);
    }
}
