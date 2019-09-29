package com.keepaccountable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.challengeFormSubmission.Challenger;
import com.keepaccountable.persist.ChallengeDAO;

@RestController
public class SubscribeService {

	@Autowired
	ChallengeDAO challengeDAO;
	
	@PostMapping(path="/subscribe/{id}", consumes="application/json", produces="application/json")
	public ChallengeFormSubmission subscribe(@PathVariable("id") String id, @RequestBody Challenger subscriber) {
		return challengeDAO.subscribe(id, subscriber);
	}
}
