package com.example.checkoutcomponent.backend.services.reposervices;

import com.example.checkoutcomponent.backend.domain.Cart;
import com.example.checkoutcomponent.backend.repositories.CartRepository;
import com.example.checkoutcomponent.backend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kamildev7 on 2017-10-30.
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> listAll() {
        List<Cart> carts = new ArrayList<>();
        cartRepository.findAll().forEach(carts::add);
        return carts;
    }

    @Override
    public Cart getById(Integer id) {
        return cartRepository.findOne(id);
    }

    @Override
    public Cart saveOrUpdate(Cart domainObject) {
        return cartRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        cartRepository.delete(id);
    }
}
