package com.example.checkoutcomponent.backend.repositories;

import com.example.checkoutcomponent.backend.domain.Cart;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kamildev7 on 2017-10-30.
 */

public interface CartRepository extends CrudRepository<Cart, Integer> {
}
