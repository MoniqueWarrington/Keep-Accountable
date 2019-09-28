package com.keepaccountable.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("token")
public class SessionController {

    @GetMapping("/session")
    public ModelAndView callback(@ModelAttribute("token") String token) {
    	ModelAndView modelAndView = new ModelAndView("session");
        modelAndView.addObject("token", token);
        return modelAndView;
    }
}
