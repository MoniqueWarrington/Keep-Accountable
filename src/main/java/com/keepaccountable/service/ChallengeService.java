package com.keepaccountable.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.persist.ChallengeDAO;

@RestController
public class ChallengeService {

	@Autowired
	ChallengeDAO challengeDAO;
	
	@PostMapping(path="/challenge", consumes="application/json", produces="application/json")
	public String create(@RequestBody ChallengeFormSubmission challenge) {
		challengeDAO.save(challenge);
		return "{ \"message\": \" Goal saved with id " + challenge.getId() + "\"}";
	}
	
	@GetMapping(value = "/challenge/{id}")
	public Optional<ChallengeFormSubmission> retrieve(@PathVariable("id") String id) {
		return challengeDAO.findById(id);
	}
}
