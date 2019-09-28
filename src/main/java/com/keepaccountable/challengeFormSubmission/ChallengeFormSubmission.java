package com.keepaccountable.challengeFormSubmission;

import lombok.Data;

@Data
public class ChallengeFormSubmission {
	private String title;
	private String description;
	private Long subscriptionAmount;
	private long subscriptionCap;
	private String imageUrl;
	private Long challengePercentage;
	private Long challengeProgress;
	private Long challengeCap;
	private String challengeUnits;
}
