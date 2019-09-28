package com.keepaccountable.persist;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;

public interface ChallengeRepository extends MongoRepository<ChallengeFormSubmission, String> {

}
