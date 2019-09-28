package com.keepaccountable.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateChallengeViewController {
	@GetMapping("/create")
	public String createChallenge(Model model) {
		return "createChallenge";
	}
}
