package com.example.checkoutcomponent.backend.services;

import java.util.List;

/**
 * @author kamildev7 on 2017-10-30.
 */

public interface CRUDService<T> {
    List<T> listAll();

    T getById(Integer id);

    T saveOrUpdate(T domainObject);

    void delete(Integer id);
}
