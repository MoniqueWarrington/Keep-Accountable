package com.keepaccountable.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HellloWorldRestController {

    @RequestMapping("/hello")
    public String greeting() {
        return "Hello, greeting to you!";
    }
}
