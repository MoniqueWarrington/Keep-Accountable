package com.keepaccountable.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class CallbackController {

    @GetMapping("/callback")
    public ModelAndView callback(@RequestParam("code") String code) {
    	ModelAndView modelAndView = new ModelAndView("callback");
        modelAndView.addObject("token", code);
        return modelAndView;
    }
}
