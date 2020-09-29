package shoppingcart.service.impl;

import shoppingcart.model.Cart;
import shoppingcart.model.CartItem;
import shoppingcart.service.DeliveryService;

public class DeliveryServiceImpl implements DeliveryService {

    @Override
    public double calculateDeliveryCost(Cart cart) {
        double cost = 0;
        for (CartItem item : cart.getProducts()){
            cost += item.getProduct().getPrice() *  item.getQuantity();
        }
        return cost;
    }
}
