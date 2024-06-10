package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class testimonial {
    @GetMapping("/testimonial")
    public String Testimonial(Model model){
        model.addAttribute("active", "testimonial");

        return"client/testimonial";
    }
    
}
