package com.example.checkoutcomponent.backend.checkoutCalculator;

import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.dto.ItemPriceWithDiscounts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author kamildev7 on 2017-10-30.
 */

public interface Calculator {
     BigDecimal ONE_HUNDRED = new BigDecimal(100);

    List<ItemPriceWithDiscounts> calculatePricesOfItemsWithDiscounts(Map<Item, Integer> itemsCount);

    BigDecimal calculateTotalPriceForCheckout(List<ItemPriceWithDiscounts> items);

    static BigDecimal calculatePercentageOfNumber(BigDecimal base, BigDecimal percentage){
        return base.multiply(percentage).divide(ONE_HUNDRED);
    }
}