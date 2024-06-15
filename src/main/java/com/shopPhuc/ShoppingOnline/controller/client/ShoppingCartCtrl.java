package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.model.User;
import com.shopPhuc.ShoppingOnline.service.SessionService;
import com.shopPhuc.ShoppingOnline.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShoppingCartCtrl {
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart",shoppingCartService);
        return "/client/cart";
    }
    @GetMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Long id , RedirectAttributes redirectAttributes) {
        User user = sessionService.get("user");
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Vui long dang nhap ");
            return "redirect:/login";
        }

        shoppingCartService.add(id);
        return "redirect:/cart/view"; // hiển thị giỏ hàng
    }
    @GetMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        shoppingCartService.remove(id);
        return "redirect:/cart/view";
    }
    @GetMapping("/cart/clear")
    public String clear() {
        shoppingCartService.clear();
        return "redirect:/cart/view";
    }
    @PostMapping("/cart/update/{id}")
    public String update(@PathVariable Long id, @RequestParam("qty") int qty) {
        shoppingCartService.update(id,qty);
        return "redirect:/cart/view";
    }
}
