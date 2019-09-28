package com.keepaccountable.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubscriberViewController {	
	@GetMapping("/subscriberview")
    public String index(Model model) {
        return "ChallengeViewSubscriber";
	}
}
