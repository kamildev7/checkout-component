package com.example.checkoutcomponent.backend.controller;

import com.example.checkoutcomponent.backend.domain.Cart;
import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.exception.ItemNotFoundException;
import com.example.checkoutcomponent.backend.services.CartService;
import com.example.checkoutcomponent.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author kamildev7 on 2017-10-30.
 */

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ItemService itemService;

    @PostMapping("/{cartId}/add/{itemId}/{quantity}")
    public ResponseEntity<?> addItem(@PathVariable Integer itemId, @PathVariable Integer quantity,
                                     @PathVariable Integer cartId) {

        Cart cart = cartService.getById(cartId);
        if (cart == null) {
            cart = cartService.saveOrUpdate(new Cart());
            cart.setItemsCount(new HashMap<>());
        }

        Item item = itemService.getById(itemId);
        if (item == null) {
            throw new IllegalArgumentException(new ItemNotFoundException(itemId));
        }

        cart.getItemsCount().put(item, quantity);

        cartService.saveOrUpdate(cart);

        return ResponseEntity.ok(cart);
    }
}
