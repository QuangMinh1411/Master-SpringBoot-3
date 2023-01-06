package com.heaven.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username,String password){
        return username.equals("Quang") && password.equals("1234");
    }
}
