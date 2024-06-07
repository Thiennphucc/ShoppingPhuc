package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.dto.dtoRegister;
import com.shopPhuc.ShoppingOnline.model.User;
import com.shopPhuc.ShoppingOnline.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class register {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/register")

    public String Register(Model model) {
        model.addAttribute("user", new dtoRegister());
        return "client/register";
    }
    @PostMapping("/register")
    public String Register(@Valid @ModelAttribute("user") dtoRegister user, BindingResult Result) {
        if(Result.hasErrors()){
            return "client/register";
        }
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());

        userRepository.save(u);

        return "client/register";
    }
    
}
