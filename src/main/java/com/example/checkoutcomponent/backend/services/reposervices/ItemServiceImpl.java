package com.example.checkoutcomponent.backend.services.reposervices;

import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.repositories.ItemRepository;
import com.example.checkoutcomponent.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kamildev7 on 2017-10-30.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> listAll() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(items::add);
        return items;
    }

    @Override
    public Item getById(Integer id) {
        return itemRepository.findOne(id);
    }

    @Override
    public Item saveOrUpdate(Item domainObject) {
        return itemRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        itemRepository.delete(id);
    }
}
