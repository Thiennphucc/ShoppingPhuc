package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalCartCtrl {
    @Autowired
    ShoppingCartService shoppingCartService;
    @ModelAttribute("CountCart")
    public int countCart() {
        return shoppingCartService.getCount();
    }
}
