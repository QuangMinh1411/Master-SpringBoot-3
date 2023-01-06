package com.heaven.webapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
    @Autowired
    private AuthenticationService authService;

    @GetMapping("/login")
    public String goLoginPage(Model model){
        return "login";
    }


    @PostMapping("/welcome")
    public String gotoWelcome(@RequestParam String name,
                              @RequestParam String password,
                              Model model){
        if(authService.authenticate(name,password)){
            model.addAttribute("name",name);

            return "welcome";
        }
        else {
            model.addAttribute("error",true);
            return "login";
        }

    }

}
