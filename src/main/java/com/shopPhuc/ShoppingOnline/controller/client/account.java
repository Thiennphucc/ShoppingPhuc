package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.dto.dtoRegister;
import com.shopPhuc.ShoppingOnline.model.User;
import com.shopPhuc.ShoppingOnline.repository.UserRepository;
import com.shopPhuc.ShoppingOnline.service.SessionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class account {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionService sessionService;

    @GetMapping("/account")
    public String About(Model model) {
        User user = sessionService.get("user");
        model.addAttribute("user", user);
        model.addAttribute("active", "account");
        return "client/profile";
    }

    @PostMapping("/account")
    public String SignUp(@Valid @ModelAttribute("user") User user ) {
        User newUser = userRepository.findByUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setAddress(user.getAddress());
        newUser.setPhone(user.getPhone());
        userRepository.save(newUser);
        sessionService.set("user", newUser);
        return "redirect:/account";
    }
}

