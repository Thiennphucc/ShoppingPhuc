package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class testimonial {
    @GetMapping("/testimonial")
    public String Testimonial(){
        return"client/testimonial";
    }
    
}
