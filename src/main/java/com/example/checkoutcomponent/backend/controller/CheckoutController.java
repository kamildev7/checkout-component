package com.example.checkoutcomponent.backend.controller;

import com.example.checkoutcomponent.backend.domain.Cart;
import com.example.checkoutcomponent.backend.dto.CheckoutReceipt;
import com.example.checkoutcomponent.backend.exception.CartNotFoundException;
import com.example.checkoutcomponent.backend.services.CartService;
import com.example.checkoutcomponent.backend.services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kamildev7 on 2017-10-30.
 */

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/{cartId}")
    public ResponseEntity<?> checkout(@PathVariable Integer cartId) {

        Cart cart = cartService.getById(cartId);
        if (cart == null) {
            throw new IllegalArgumentException(new CartNotFoundException(cartId));
        }

        CheckoutReceipt checkoutReceipt = checkoutService.checkout(cart.getItemsCount());

        return ResponseEntity.ok(checkoutReceipt);
    }

}
