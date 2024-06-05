package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class about {
    @GetMapping("/about")
    public String About(){
        return"client/about";
    }
    
}
