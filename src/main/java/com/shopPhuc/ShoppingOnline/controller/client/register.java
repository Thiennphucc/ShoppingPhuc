package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class register {
    @GetMapping("/register")
    public String Register() {
        return "client/register";
    }
    
}
