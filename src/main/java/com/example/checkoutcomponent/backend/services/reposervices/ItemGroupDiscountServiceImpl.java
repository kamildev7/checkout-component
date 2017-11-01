package com.example.checkoutcomponent.backend.services.reposervices;

import com.example.checkoutcomponent.backend.domain.ItemGroupDiscount;
import com.example.checkoutcomponent.backend.repositories.ItemGroupDiscountRepository;
import com.example.checkoutcomponent.backend.services.ItemGroupDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kamildev7 on 2017-11-01.
 */

@Service
public class ItemGroupDiscountServiceImpl implements ItemGroupDiscountService {

    @Autowired
    private ItemGroupDiscountRepository itemGroupDiscountRepository;

    @Override
    public List<ItemGroupDiscount> listAll() {
        List<ItemGroupDiscount> itemsDiscounts = new ArrayList<>();
        itemGroupDiscountRepository.findAll().forEach(itemsDiscounts::add);
        return itemsDiscounts;
    }

    @Override
    public ItemGroupDiscount getById(Integer id) {
        return itemGroupDiscountRepository.findOne(id);
    }

    @Override
    public ItemGroupDiscount saveOrUpdate(ItemGroupDiscount domainObject) {
        return itemGroupDiscountRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        itemGroupDiscountRepository.delete(id);
    }
}
