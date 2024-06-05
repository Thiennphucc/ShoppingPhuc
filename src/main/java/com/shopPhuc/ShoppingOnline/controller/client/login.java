package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class login {
    @GetMapping("/login")
    public String Longin() {
        return "client/login";
    }
    
}
