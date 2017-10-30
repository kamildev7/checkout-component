package com.example.checkoutcomponent.backend.exception;

/**
 * @author kamildev7 on 2017-10-30.
 */

public class CartNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -694354952032293587L;
    private Integer cartId;

    public CartNotFoundException(Integer cartId) {
        super("Cart with id " + cartId + " does not exist");
        this.cartId = cartId;
    }
}
