package com.example.checkoutcomponent.backend.checkoutCalculator;

import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.dto.ItemPriceWithDiscount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author kamildev7 on 2017-10-30.
 */

public interface Calculator {
    List<ItemPriceWithDiscount> calculateTotalPriceOfItems(Map<Item, Integer> itemsCount);

    BigDecimal calculateTotalPriceForCheckout(List<ItemPriceWithDiscount> items);
}