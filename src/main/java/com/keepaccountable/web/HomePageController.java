package com.keepaccountable.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;
import com.keepaccountable.persist.ChallengeDAO;

@Controller
public class HomePageController {

	@Autowired
	ChallengeDAO dao;
	
    @GetMapping("/")
    public String index(Model model) {	
		
    	
		ChallengeFormSubmission ch1 = tryGetData(0);
    	
    	ChallengeFormSubmission ch2 = tryGetData(1);
    	
    	ChallengeFormSubmission ch3 = tryGetData(2);
    	    	
    	model.addAttribute("href1",ch1.getId());
    	model.addAttribute("href2",ch2.getId());
    	model.addAttribute("href3",ch3.getId());
    	
    	
    	model.addAttribute("title1", ch1.getTitle());
    	model.addAttribute("title2", ch2.getTitle());
    	model.addAttribute("title3", ch3.getTitle());
    	
    	model.addAttribute("desc1", ch1.getDescription());
    	model.addAttribute("desc2", ch2.getDescription());
    	model.addAttribute("desc3", ch3.getDescription());
    	
    	model.addAttribute("penalty1", ch1.getPenaltyAmount());
    	model.addAttribute("penalty2", ch2.getPenaltyAmount());
    	model.addAttribute("penalty3", ch3.getPenaltyAmount());
    	
    	
        return "HomePage";
    }
    
    ChallengeFormSubmission tryGetData(int index) {
    	List<ChallengeFormSubmission> chList = dao.findAll();
    	ChallengeFormSubmission ch1;
    	try {
    		ch1 = chList.get(index);
    	}
    	catch(Exception e) {
    		ch1 = makeTestChallengeFormSubmission();
    	}
    	return ch1;
    }
    
    private ChallengeFormSubmission makeTestChallengeFormSubmission() {
		ChallengeFormSubmission ch = new ChallengeFormSubmission();
		ch.setId("#");
		ch.setTitle("No fast food for 20 weeks");
		ch.setDescription("pulvinar ante, eu facilisis nisl");
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
