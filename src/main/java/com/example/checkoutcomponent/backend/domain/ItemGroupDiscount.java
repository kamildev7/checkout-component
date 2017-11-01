package com.example.checkoutcomponent.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author kamildev7 on 2017-11-01.
 */

@Entity
public class ItemGroupDiscount {

    @Id
    private Integer firstItemId;

    @NotNull
    private Integer secondItemId;

    @NotNull
    private BigDecimal discountPercent;

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Integer getFirstItemId() {
        return firstItemId;
    }

    public void setFirstItemId(Integer firstItemId) {
        this.firstItemId = firstItemId;
    }

    public Integer getSecondItemId() {
        return secondItemId;
    }

    public void setSecondItemId(Integer secondItemId) {
        this.secondItemId = secondItemId;
    }
}
