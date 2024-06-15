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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class productCtrl {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String products(Model model,
                           @RequestParam("keywords") Optional<String> keywords,
                           @RequestParam("p") Optional<Integer> page) {

        model.addAttribute("active", "products");

        // Default values
        String searchKeywords = keywords.orElse("");
        int currentPage = page.orElse(0);

        // Page size and pagination
        int pageSize = 8;
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        // Retrieve products based on search keywords and pagination
        Page<product> productPage = productRepository.findByTitleContaining(searchKeywords, pageable);

        // Add attributes to the model
        model.addAttribute("page", productPage);
        model.addAttribute("keywords", searchKeywords);

        // Display IDs of products for testing
        for (product product : productPage.getContent()) {
            System.out.println(product.getId());
        }

        return "client/Products";
    }
}
