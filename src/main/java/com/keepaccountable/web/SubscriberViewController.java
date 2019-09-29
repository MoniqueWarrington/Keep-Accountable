package com.keepaccountable.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.persist.ChallengeDAO;

@Controller
public class SubscriberViewController {	
	
	@Autowired
	ChallengeDAO dao;
	
	@GetMapping("/{challengeId}")
    public String index(Model model, @PathVariable(value="challengeId") String id) {
		
		Optional<ChallengeFormSubmission> chOptional = dao.findById(id);
		ChallengeFormSubmission ch = null; 
		if(chOptional.isPresent()) {
			ch = chOptional.get();
		}
		
		if(ch != null) {
			model.addAttribute("id", id);
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
		}		
		
		return "ChallengeViewSubscriber";	
	}
	
	private ChallengeFormSubmission makeTestChallengeFormSubmission() {
		ChallengeFormSubmission ch = new ChallengeFormSubmission();
		ch.setTitle("No fast food for 20 weeks");
		ch.setDescription("accumsan, est turpis pulvinar ante, eu facilisis nisl");
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
