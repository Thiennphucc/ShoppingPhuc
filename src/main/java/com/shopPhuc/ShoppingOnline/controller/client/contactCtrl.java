package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class contactCtrl {
    @GetMapping("/contact")
    public String Contact(Model model){
        model.addAttribute("active", "contact");

        return"client/contact";
    }
    
}
