package com.example.checkoutcomponent.backend.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kamildev7 on 2017-10-30.
 */

public class CheckoutReceipt {
    private List<ItemPriceWithDiscounts> items;
    private BigDecimal totalPrice;

    public CheckoutReceipt(List<ItemPriceWithDiscounts> items, BigDecimal totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public List<ItemPriceWithDiscounts> getItems() {
        return items;
    }

    public void setItems(List<ItemPriceWithDiscounts> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
