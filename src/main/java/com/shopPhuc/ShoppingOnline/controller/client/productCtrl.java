package com.shopPhuc.ShoppingOnline.controller.client;

import com.shopPhuc.ShoppingOnline.model.product;
import com.shopPhuc.ShoppingOnline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class productCtrl {
        @Autowired
        ProductRepository productRepository;
        @GetMapping("/product")

        public String product(Model model, @RequestParam("keywords") Optional<String> kw,
                              @RequestParam("p") Optional<Integer> p) {
            model.addAttribute("active", "product");
            String kwords = kw.orElse("");
            Pageable pageable = PageRequest.of(p.orElse(0), 8);
            Page<product> page = productRepository.findByTitleContaining(kwords, pageable);
            model.addAttribute("page", page);
            model.addAttribute("kw", kwords);
            for (product product1 : page.getContent()) {
                System.out.println(product1.getId());
            }
            return "client/Products";
        }
    
}

