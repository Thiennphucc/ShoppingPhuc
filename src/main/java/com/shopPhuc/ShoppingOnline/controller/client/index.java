package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class index {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("active", "index");
        return "client/index";
    }
    
}
