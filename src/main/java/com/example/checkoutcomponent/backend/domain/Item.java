package com.example.checkoutcomponent.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author kamildev7 on 2017-10-30.
 */


@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private BigDecimal price;
    private BigDecimal specialPrice;
    private int quantityRequirementForDiscount;
    private boolean hasDiscount;

    public boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityRequirementForDiscount() {
        return quantityRequirementForDiscount;
    }

    public void setQuantityRequirementForDiscount(int quantityRequirementForDiscount) {
        this.quantityRequirementForDiscount = quantityRequirementForDiscount;
    }

    public BigDecimal getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(BigDecimal specialPrice) {
        this.specialPrice = specialPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!getId().equals(item.getId())) return false;
        if (!getName().equals(item.getName())) return false;
        return getPrice().equals(item.getPrice());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", specialPrice=" + specialPrice +
                ", quantityRequirementForDiscount=" + quantityRequirementForDiscount +
                ", hasDiscount=" + hasDiscount +
                '}';
    }
}