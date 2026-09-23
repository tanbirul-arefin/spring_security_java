package com.real.spring_security_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class mainController {

    @GetMapping( "/login")
    public String loginPage(){
        return "login-page";
    }


    @GetMapping("/protected")
    public String protectedPage(){
        return "protected-page";
    }

}
