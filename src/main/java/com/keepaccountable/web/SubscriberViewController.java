package com.keepaccountable.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;

@Controller
public class SubscriberViewController {	
	
	@GetMapping("/subscriberview")
    public String index(Model model) {		
		ChallengeFormSubmission ch = makeTestChallengeFormSubmission();
		
		model.addAttribute("title", ch.getTitle());
		model.addAttribute("description", ch.getDescription());
		model.addAttribute("penaltyAmount", ch.getPenaltyAmount());		
		model.addAttribute("subscriptionAmount", ch.getSubscriptionAmount());
		model.addAttribute("subscriptionCap", ch.getSubscriptionCap());
		model.addAttribute("imageUrl", ch.getImageUrl());
		model.addAttribute("challengePercentage", ch.getChallengePercentage());
		model.addAttribute("challengeProgress", ch.getChallengeProgress());
		model.addAttribute("challengeCap", ch.getChallengeCap());
		model.addAttribute("challengeUnits", ch.getChallengeUnits());
				return "ChallengeViewSubscriber";	
	}
	
	private ChallengeFormSubmission makeTestChallengeFormSubmission() {
		ChallengeFormSubmission ch = new ChallengeFormSubmission();
		ch.setTitle("No fast food for 20 weeks");
		ch.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed ac tempor ipsum. Sed orci sem, facilisis accumsan faucibus gravida, convallis sed velit. Fusce in elementum felis, non semper est. Phasellus pulvinar fermentum est, at hendrerit nulla porttitor in. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque et justo vitae neque condimentum mattis id vel libero. Nam porttitor lobortis odio, ac viverra ante mollis non. Sed imperdiet molestie leo cursus ultricies. Aenean tincidunt commodo ante, lacinia molestie elit blandit vehicula. Sed tincidunt bibendum risus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.\r\n" + 
				"\r\n" + 
				"Suspendisse et finibus dolor. Donec accumsan mauris vel est egestas ornare. Sed tristique nisi sit amet turpis mattis condimentum. Sed bibendum sapien nec imperdiet mollis. Suspendisse ullamcorper, neque ac fermentum accumsan, est turpis pulvinar ante, eu facilisis nisl");
		ch.setSubscriptionAmount(5L);
		ch.setSubscriptionCap(500L);
		ch.setImageUrl("https://vignette.wikia.nocookie.net/parksandrecreation/images/3/38/Leslie.png/revision/latest?cb=20111015205925");
		ch.setChallengePercentage(50L);
		ch.setChallengeProgress(10L);
		ch.setChallengeCap(20L);
		ch.setChallengeUnits("Weeks");
		ch.setPenaltyAmount(250L);
		return ch;
	}
}
