package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class logout {
    @Autowired
    SessionService sessionService;
    @GetMapping("/logout")

    public String logout() {
        sessionService.remove("user");
        return "redirect:/login";
    }

}
