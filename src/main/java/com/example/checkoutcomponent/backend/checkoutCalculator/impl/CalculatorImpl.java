package com.example.checkoutcomponent.backend.checkoutCalculator.impl;

import com.example.checkoutcomponent.backend.checkoutCalculator.Calculator;
import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.dto.ItemPriceWithDiscount;
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

    @Override
    public List<ItemPriceWithDiscount> calculateTotalPriceOfItems(Map<Item, Integer> itemsCount) {
        return itemsCount.entrySet().stream().map(this::calculateTotalPriceOfItems).collect(Collectors.toList());
    }

    private ItemPriceWithDiscount calculateTotalPriceOfItems(Map.Entry<Item, Integer> itemEntry) {
        Item item = itemEntry.getKey();

        BigDecimal priceWithDiscount = calculateTotalPriceOfItem(item, itemEntry.getValue());

        return new ItemPriceWithDiscount(item.getId(), itemEntry.getValue(), priceWithDiscount);
    }

    private BigDecimal calculateTotalPriceOfItem(Item item, Integer quantity) {
        if (!item.isHasDiscount()) return item.getPrice().multiply(BigDecimal.valueOf(quantity));

        BigDecimal unitsWithSpecialPrice = item.getSpecialPrice()
                .multiply(BigDecimal.valueOf(quantity / item.getQuantityRequirementForDiscount()));

        BigDecimal unitsWithoutSpecialPrice = item.getPrice()
                .multiply(BigDecimal.valueOf(quantity % item.getQuantityRequirementForDiscount()));

        return unitsWithoutSpecialPrice.add(unitsWithSpecialPrice);
    }

    @Override
    public BigDecimal calculateTotalPriceForCheckout(List<ItemPriceWithDiscount> items) {
        return items.stream().map(a -> a.getTotalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
