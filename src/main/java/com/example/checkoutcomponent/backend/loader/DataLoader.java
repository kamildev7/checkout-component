package com.example.checkoutcomponent.backend.loader;

import com.example.checkoutcomponent.backend.domain.Cart;
import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.services.CartService;
import com.example.checkoutcomponent.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kamildev7 on 2017-10-30.
 */

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ItemService itemService;

    @Autowired
    private CartService cartService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Item item = new Item();
        item.setName("A");
        item.setPrice(new BigDecimal(40));
        item.setSpecialPrice(new BigDecimal(70));
        item.setQuantityRequirementForDiscount(3);
        item.setHasDiscount(true);
        itemService.saveOrUpdate(item);

        Item item2 = new Item();
        item2.setName("B");
        item2.setPrice(new BigDecimal(10));
        item2.setSpecialPrice(new BigDecimal(15));
        item2.setQuantityRequirementForDiscount(2);
        item2.setHasDiscount(true);
        itemService.saveOrUpdate(item2);

        Item item3 = new Item();
        item3.setName("C");
        item3.setPrice(new BigDecimal(30));
        item3.setSpecialPrice(new BigDecimal(60));
        item3.setQuantityRequirementForDiscount(4);
        item3.setHasDiscount(true);
        itemService.saveOrUpdate(item3);

        Item item4 = new Item();
        item4.setName("D");
        item4.setPrice(new BigDecimal(25));
        item4.setSpecialPrice(new BigDecimal(40));
        item4.setQuantityRequirementForDiscount(2);
        item4.setHasDiscount(true);
        itemService.saveOrUpdate(item4);

        Cart cart = new Cart();
        Map<Item, Integer> itemMap = new HashMap<>();
        itemMap.put(item, 13);
        itemMap.put(item2, 11);
        itemMap.put(item3, 7);
        itemMap.put(item4, 2);

        cart.setItemsCount(itemMap);
        cartService.saveOrUpdate(cart);
    }
}
