package com.example.checkoutcomponent.backend.domain;

import javax.persistence.*;
import java.util.Map;

/**
 * @author kamildev7 on 2017-10-30.
 */

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Item and quantity
    @ElementCollection
    private Map<Item, Integer> itemsCount;

    public Map<Item, Integer> getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(Map<Item, Integer> itemsCount) {
        this.itemsCount = itemsCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", itemsCount=" + itemsCount +
                '}';
    }
}