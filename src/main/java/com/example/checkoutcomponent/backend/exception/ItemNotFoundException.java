package com.example.checkoutcomponent.backend.exception;

/**
 * @author kamildev7 on 2017-10-30.
 */

public class ItemNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -694354952032299587L;
    private Integer itemId;

    public ItemNotFoundException(Integer itemId) {
        super("Item with id " + itemId + " does not exist");
        this.itemId = itemId;
    }

    public ItemNotFoundException() {
        super("Items not found");
    }
}