package com.shopPhuc.ShoppingOnline.Impl;

import com.shopPhuc.ShoppingOnline.model.product;
import com.shopPhuc.ShoppingOnline.repository.ProductRepository;
import com.shopPhuc.ShoppingOnline.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ProductRepository productRepository;
    private Map<Long, product> map = new HashMap<>();

    @Override
    public product add(Long id) {
        product item = map.get(id);
        if (item == null) {
            Optional<product> product = productRepository.findById(id);
            if (product.isPresent()) {
                item = new product();
                item.setId(product.get().getId());
                item.setTitle(product.get().getTitle());
                item.setPrice(product.get().getPrice());
                item.setQty(1);
                map.put(id, item);
            }
        } else {
            item.setQty(item.getQty() + 1);
        }
        return item;
    }

    @Override
    public void remove(Long id) {
        map.remove(id);
    }

    @Override
    public product update(Long id, int qty) {
        product item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
        return item;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<product> getProducts() {
        return map.values();
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(item -> item.getPrice() * item.getQty())
                .sum();
    }
}
