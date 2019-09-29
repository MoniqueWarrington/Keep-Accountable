package com.keepaccountable.persist;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.challengeFormSubmission.Challenger;

@Repository
public class ChallengeDAO {

	@Autowired
	ChallengeRepository challengeRepository;
	
	public ChallengeFormSubmission save(ChallengeFormSubmission challenge) {
		challengeRepository.save(challenge);
		return challenge;
	}
	
	public Optional<ChallengeFormSubmission> findById(String id) {
		return challengeRepository.findById(id);
	}
	
	public List<ChallengeFormSubmission> findAll(){
		return challengeRepository.findAll();
	}
	
	public ChallengeFormSubmission subscribe(String id, Challenger newSubscriber) {
		if (id == null)
			return null;
		
		Optional<ChallengeFormSubmission> opt = challengeRepository.findById(id);
		
		if (opt.get() == null)
			return null;
		
		ChallengeFormSubmission challenge = opt.get();
		if (challenge.getSubscribers() == null)
			challenge.setSubscribers(new ArrayList<>());
		challenge.getSubscribers().add(newSubscriber);
		
		return save(challenge);
	} 
	
}
