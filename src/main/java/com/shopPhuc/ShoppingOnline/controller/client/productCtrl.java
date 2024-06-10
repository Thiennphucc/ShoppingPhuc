package com.shopPhuc.ShoppingOnline.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class productCtrl {
    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("active", "product");

        return "client/product2";
    }
    
}

