package com.example.checkoutcomponent.backend.repositories;

import com.example.checkoutcomponent.backend.domain.Item;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kamildev7 on 2017-10-30.
 */
public interface ItemRepository extends CrudRepository<Item, Integer> {
}

