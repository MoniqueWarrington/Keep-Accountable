package com.keepaccountable.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;

import lombok.extern.slf4j.Slf4j;

@RestController
public class CreateChallengeRestController {

	@PostMapping(path="/createChallenge", consumes="application/json", produces="application/json") 
    public String createChallenge(@RequestBody ChallengeFormSubmission challenge) {
    	return challenge.getTitle();
    }
    
}