package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class about {
    @GetMapping("/about")
    public String About(Model model){
        model.addAttribute("active", "about");
        return"client/about";
    }
    
}
