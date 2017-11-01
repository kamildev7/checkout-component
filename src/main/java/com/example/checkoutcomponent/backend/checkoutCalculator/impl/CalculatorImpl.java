package com.example.checkoutcomponent.backend.checkoutCalculator.impl;

import com.example.checkoutcomponent.backend.checkoutCalculator.Calculator;
import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.domain.ItemGroupDiscount;
import com.example.checkoutcomponent.backend.dto.ItemPriceWithDiscounts;
import com.example.checkoutcomponent.backend.services.ItemGroupDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author kamildev7 on 2017-10-30.
 */

@Component
public class CalculatorImpl implements Calculator {

    @Autowired
    private ItemGroupDiscountService itemGroupDiscountService;

    @Override
    public List<ItemPriceWithDiscounts> calculatePricesOfItemsWithDiscounts(Map<Item, Integer> itemsCount) {
        return itemsCount.entrySet().stream().map(this::calculateTotalPriceOfItem).collect(Collectors.toList());
    }

    private ItemPriceWithDiscounts calculateTotalPriceOfItem(Map.Entry<Item, Integer> itemEntry) {
        Item item = itemEntry.getKey();
        BigDecimal totalItemPrice = addUnitDiscount(item, itemEntry.getValue());

        ItemGroupDiscount itemGroupDiscount = itemGroupDiscountService.getById(item.getId());

        if (itemGroupDiscount != null) {
            totalItemPrice = addGroupDiscount(totalItemPrice, itemGroupDiscount.getDiscountPercent());
        }


        return new ItemPriceWithDiscounts(item.getId(), itemEntry.getValue(), totalItemPrice);
    }

    private BigDecimal addUnitDiscount(Item item, Integer quantity) {
        if (!item.isHasDiscount()) return item.getPrice().multiply(BigDecimal.valueOf(quantity));

        BigDecimal unitsWithSpecialPrice = item.getSpecialPrice()
                .multiply(BigDecimal.valueOf(quantity / item.getQuantityRequirementForDiscount()));

        BigDecimal unitsWithoutSpecialPrice = item.getPrice()
                .multiply(BigDecimal.valueOf(quantity % item.getQuantityRequirementForDiscount()));

        return unitsWithoutSpecialPrice.add(unitsWithSpecialPrice);
    }

    private BigDecimal addGroupDiscount(BigDecimal totalItemPrice, BigDecimal itemGroupDiscount) {
        return totalItemPrice.subtract(Calculator.calculatePercentageOfNumber(totalItemPrice, itemGroupDiscount));
    }

    @Override
    public BigDecimal calculateTotalPriceForCheckout(List<ItemPriceWithDiscounts> items) {
        return items.stream().map(a -> a.getTotalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
