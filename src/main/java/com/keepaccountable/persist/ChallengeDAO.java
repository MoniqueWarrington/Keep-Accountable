package com.keepaccountable.persist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;

@Repository
public class ChallengeDAO {

	@Autowired
	ChallengeRepository challengeRepository;
	
	public void save(ChallengeFormSubmission challenge) {
		challengeRepository.save(challenge);
	}
	
	public Optional<ChallengeFormSubmission> findById(String id) {
		return challengeRepository.findById(id);
	}
}
