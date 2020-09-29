package shoppingcart.exception;

import shoppingcart.model.Discount;

public class DiscountException extends Exception {

    public DiscountException(Discount discount) {
        super("discount is not valid:" + discount.getRate());
    }

}
