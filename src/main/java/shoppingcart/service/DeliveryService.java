package shoppingcart.service;

import shoppingcart.model.Cart;

public interface DeliveryService {

    /**
     * Calculates delivery cost of the cart.
     *
     * @param cart cart that will be calculated.
     * @return cost of the cart.
     */
    double calculateDeliveryCost(Cart cart);
}
