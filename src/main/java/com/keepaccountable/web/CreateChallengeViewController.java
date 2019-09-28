package com.keepaccountable.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;

@Controller
public class CreateChallengeViewController {
	@GetMapping("/create")
	public String createChallenge(Model model) {
		ChallengeFormSubmission form = new ChallengeFormSubmission();
		form.setTitle("Hello World");
		model.addAttribute("challengeFormSubmission", form);
		return "createChallenge";
	}
	
	@PostMapping("/create")
	public String createSubmit(@ModelAttribute ChallengeFormSubmission challengeFormSubmission) {
		System.out.print(challengeFormSubmission.getTitle());
		return "What is good famsquad, the title you sent is: " + challengeFormSubmission.getTitle();
	}
}
