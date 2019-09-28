package com.keepaccountable.challengeFormSubmission;

public class ChallengeFormSubmission {
	private String title;
	private String description;
	private Long subscriptionAmount;
	private long subscriptionCap;
	private String imageUrl;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getSubscriptionAmount() {
		return subscriptionAmount;
	}
	public void setSubscriptionAmount(Long subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}
	public long getSubscriptionCap() {
		return subscriptionCap;
	}
	public void setSubscriptionCap(long subscriptionCap) {
		this.subscriptionCap = subscriptionCap;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
