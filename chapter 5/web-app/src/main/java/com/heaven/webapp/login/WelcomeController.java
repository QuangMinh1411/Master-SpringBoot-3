package com.heaven.webapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller

public class WelcomeController {


    @GetMapping("/")
    public String goWelcomePage(Model model){
        model.addAttribute("name",getLoggedinUsername());
        return "welcome";
    }

    private String getLoggedinUsername(){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
