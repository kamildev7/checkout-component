package com.example.checkoutcomponent.backend.services;

import com.example.checkoutcomponent.backend.checkoutCalculator.Calculator;
import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.dto.CheckoutReceipt;
import com.example.checkoutcomponent.backend.dto.ItemPriceWithDiscounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author kamildev7 on 2017-10-30.
 */

@Component
public class CheckoutService {

    @Autowired
    private Calculator itemCalculator;

    public CheckoutReceipt checkout(Map<Item, Integer> itemsCount) {
        List<ItemPriceWithDiscounts> itemsWithDiscounts = itemCalculator.calculatePricesOfItemsWithDiscounts(itemsCount);
        BigDecimal checkoutPrice = itemCalculator.calculateTotalPriceForCheckout(itemsWithDiscounts);

        return new CheckoutReceipt(itemsWithDiscounts, checkoutPrice);
    }
}