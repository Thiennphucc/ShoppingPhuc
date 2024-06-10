package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.model.User;
import com.shopPhuc.ShoppingOnline.repository.UserRepository;
import com.shopPhuc.ShoppingOnline.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class account {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionService sessionService;
    @GetMapping("/account")
    public String About(Model model){
        User user = sessionService.get("user");
        model.addAttribute("user", user);
        model.addAttribute("active", "account");
        return"client/profile";
    }
}
