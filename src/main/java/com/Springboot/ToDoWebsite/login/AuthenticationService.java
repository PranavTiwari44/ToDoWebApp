package com.Springboot.ToDoWebsite.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){
        if(username.equalsIgnoreCase("Pranav Tiwari")&&password.equals("qwertyui")){
            return true;
        }
        return false;
    }
}
