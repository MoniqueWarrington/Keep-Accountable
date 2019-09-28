package com.keepaccountable.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("token")
public class CallbackController {

	@ModelAttribute("token")
	public String getToken() {
	    return "token";
	}
	
    @GetMapping("/callback")
    public ModelAndView callback(@RequestParam("code") String code, @ModelAttribute("token") String token) {
    	ModelAndView modelAndView = new ModelAndView("callback");
        modelAndView.addObject("token", code);
        token = code;
        return modelAndView;
    }
}
