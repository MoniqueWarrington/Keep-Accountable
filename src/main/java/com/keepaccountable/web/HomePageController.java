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
		List<ChallengeFormSubmission> chList = dao.findAll();
    	
		ChallengeFormSubmission ch1 = chList.get(0);
    	
    	ChallengeFormSubmission ch2 = chList.get(0);
    	
    	ChallengeFormSubmission ch3 = chList.get(0);
    	    	
    	model.addAttribute("href1",ch1.getId());
    	model.addAttribute("href2",ch1.getId());
    	model.addAttribute("href3",ch1.getId());
    	
    	
    	model.addAttribute("title1", ch1.getTitle());
    	model.addAttribute("title2", ch2.getTitle());
    	model.addAttribute("title3", ch3.getTitle());
    	
    	model.addAttribute("desc1", ch1.getDescription());
    	model.addAttribute("desc2", ch2.getDescription());
    	model.addAttribute("desc3", ch3.getDescription());
    	
    	model.addAttribute("penalty1", ch1.getSubscriptionAmount());
    	model.addAttribute("penalty2", ch2.getSubscriptionAmount());
    	model.addAttribute("penalty3", ch3.getSubscriptionAmount());
    	
    	
        return "HomePage";
    }
}
