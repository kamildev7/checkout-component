package com.example.checkoutcomponent.backend.controller;

import com.example.checkoutcomponent.backend.domain.Item;
import com.example.checkoutcomponent.backend.exception.ItemNotFoundException;
import com.example.checkoutcomponent.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kamildev7 on 2017-10-30.
 */


@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping()
    public ResponseEntity<?> getItems() {
        List<Item> items = itemService.listAll();
        if (items == null) {
            throw new IllegalArgumentException(new ItemNotFoundException());
        }
        return ResponseEntity.ok(items);
    }

}