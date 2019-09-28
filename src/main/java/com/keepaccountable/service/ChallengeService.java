package com.keepaccountable.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.persist.ChallengeRepository;

@RestController
public class ChallengeService {

	@Autowired
	ChallengeRepository challengeRepository;
	
	@PostMapping(value = "/challenge")
	public void create(@RequestBody ChallengeFormSubmission challenge) {
		challengeRepository.save(challenge);
	}
	
	@GetMapping(value = "/challenge/{id}")
	public Optional<ChallengeFormSubmission> retrieve(@PathVariable("id") String id) {
		return challengeRepository.findById(id);
	}
}
