package com.shopPhuc.ShoppingOnline.controller.admin;

import com.shopPhuc.ShoppingOnline.model.User;
import com.shopPhuc.ShoppingOnline.model.category;
import com.shopPhuc.ShoppingOnline.model.product;
import com.shopPhuc.ShoppingOnline.repository.CategoryRepository;
import com.shopPhuc.ShoppingOnline.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ManegerProduct {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/admin/ManagerProduct")
    public String Managerproduct(Model model, @RequestParam("keywords") Optional<String> kw,
                          @RequestParam("p") Optional<Integer> p) {
        model.addAttribute("active", "product");
        String kwords = kw.orElse("");
        Pageable pageable = PageRequest.of(p.orElse(0), 8);
        Page<product> page = productRepository.findByTitleContaining(kwords, pageable);
        model.addAttribute("page", page);
        model.addAttribute("kw", kwords);

        return "admin/ManagerProducts";
    }
    @GetMapping("/admin/ManagerProduct/edit/{id}")
    public String editproduct(Model model,@PathVariable("id") Long id) {

    Optional<product> productOptional = productRepository.findById(id);
    if(productOptional.isPresent()) model.addAttribute("product", productOptional.get());
        return "admin/EditProduct";
    }

    @ModelAttribute("categories")
    public List<category> categories() {
        return categoryRepository.findAll();
    }
    @PostMapping("/admin/ManagerProduct/edit")
    public String editProduct(@ModelAttribute("product") product updatedProduct,
    @RequestParam("categoryid") Long id
    ) {
        System.out.println("updating product");


        // Retrieve the original product from the database using its ID
        Optional<product> optionalProduct = productRepository.findById(updatedProduct.getId());

        if (optionalProduct.isPresent()) {
            product originalProduct = optionalProduct.get();

            // Update the original product with the updated details
            originalProduct.setTitle(updatedProduct.getTitle());
            originalProduct.setPrice(updatedProduct.getPrice());
            originalProduct.setCategory(categoryRepository.findById(id).isPresent() ? categoryRepository.findById(id).get() : null);

            // Save the updated product back to the database
            productRepository.save(originalProduct);

            // Redirect to the product manager page
            return "redirect:/admin/ManagerProduct";
        } else {
            // Handle the case where the product with the given ID is not found
            return "redirect:/admin/ManagerProduct"; // or any other appropriate action
        }
    }
    @GetMapping("/admin/ManagerProduct/add")
    public String addproduct(Model model) {
        product p = new product();
        model.addAttribute("product", p);
        return "admin/AddProduct";
    }
    @PostMapping("/admin/ManagerProduct/add")
    public String addProduct(@ModelAttribute("product") product p,@RequestParam("categoryId") Long id ) {
        p.setCategory(categoryRepository.findById(id).isPresent() ? categoryRepository.findById(id).get() : null);
        productRepository.save(p);
        return "redirect:/admin/ManagerProduct";
    }
}
