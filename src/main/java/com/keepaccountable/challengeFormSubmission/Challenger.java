package com.keepaccountable.challengeFormSubmission;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Challenger {

	@JsonProperty("email")
	private String email;
	
	@JsonProperty("account")
	private String account;
	
}
