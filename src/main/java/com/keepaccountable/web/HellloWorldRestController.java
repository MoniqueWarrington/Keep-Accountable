package com.keepaccountable.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepaccountable.challengeFormSubmission.ChallengeFormSubmission;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HellloWorldRestController {

    @RequestMapping("/hello")
    public String greeting() {
        return "Hello, greeting to you!";
    }
    
}
