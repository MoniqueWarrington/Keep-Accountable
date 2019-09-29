package com.keepaccountable.persist;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
	
	public List<ChallengeFormSubmission> findAll(){
		return challengeRepository.findAll();
	}
	
}
