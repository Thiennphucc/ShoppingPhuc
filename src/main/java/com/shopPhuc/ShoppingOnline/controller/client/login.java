package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.model.User;
import com.shopPhuc.ShoppingOnline.repository.UserRepository;
import com.shopPhuc.ShoppingOnline.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class login {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionService sessionService;
    @GetMapping("/login")
    public String ShowLogin() {
        return "client/login";

    }
    @PostMapping("/login")
    public String Login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username: " + username + " password: " + password);
       User user = userRepository.findByUsername(username);
       if(user == null) {
           System.out.println("user not found");
       }else{
           if(user.getPassword().equals(password)) {
               System.out.println("Đăng nhập thành công");
               sessionService.set("user", user);
           }else{
               System.out.println("Đăng nhập thất bại");
           }
       }

        return "client/login";
    }

}
