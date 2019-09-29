package com.keepaccountable.challengeFormSubmission;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
public class ChallengeFormSubmission {

    @Id
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("subscriptionAmount")
    private Long subscriptionAmount;

    @JsonProperty("subscriptionCap")
    private long subscriptionCap;

    @JsonProperty("imageUrl")
    private String imageUrl;

    @JsonProperty("challengePercentage")
    private Long challengePercentage;

    @JsonProperty("challengeProgress")
    private Long challengeProgress;

    @JsonProperty("challengeCap")
    private Long challengeCap;

    @JsonProperty("challengeUnits")
    private String challengeUnits;

    @JsonProperty("penaltyAmount")
    private Long penaltyAmount;

    private String token;
}
