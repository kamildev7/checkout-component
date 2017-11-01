package com.example.checkoutcomponent.backend.dto;

import java.math.BigDecimal;

/**
 * @author kamildev7 on 2017-10-30.
 */

public class ItemPriceWithDiscounts {
    private Integer id;
    private Integer quantity;
    private BigDecimal totalPrice;

    public ItemPriceWithDiscounts(Integer id, Integer quantity, BigDecimal totalPrice) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


}
