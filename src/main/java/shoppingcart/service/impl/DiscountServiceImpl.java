package shoppingcart.service.impl;

import shoppingcart.exception.DiscountException;
import shoppingcart.model.*;
import shoppingcart.service.DiscountService;

import java.util.ArrayList;
import java.util.List;

public class DiscountServiceImpl implements DiscountService {


    @Override
    public void applyCampaign(Shop shop, Campaign campaign) throws DiscountException {
        if (campaign.getRate() > 100 || campaign.getRate() < 0) {
            throw new DiscountException(campaign);
        }
        for (Product product : shop.getProductList()) {
            Category category = product.getCategory();
            while (category != null) {
                if (category.equals(campaign.getCategory())) {
                    double newPrice = product.getPrice() * (1 - (double) campaign.getRate() / 100);
                    product.setPrice(newPrice);
                    break;
                } else {
                    category = category.getParent();
                }
            }
        }
    }

    @Override
    public void applyCoupon(Coupon coupon, Cart cart) throws DiscountException {
        if (coupon.getRate() > 100 || coupon.getRate() < 0) {
            throw new DiscountException(coupon);
        }
        int itemCount = 0;
        List<CartItem> discountedList = new ArrayList<>();
        for (int i = 0; i < cart.getProducts().size(); i++) {
            itemCount = itemCount + (cart.getProducts().get(i).getQuantity());
            CartItem currentItem = cart.getProducts().get(i);
            Product p = new Product(currentItem.getProduct().getTitle(), currentItem.getProduct().getPrice(), currentItem.getProduct().getCategory());
            double newPrice = p.getPrice() * (1 - (double) coupon.getRate() / 100);
            p.setPrice(newPrice);
            int quantity = currentItem.getQuantity();
            discountedList.add(new CartItem(p, quantity));
        }
        if (itemCount <= coupon.getMinimumItemForDiscount()) {
            return;
        }
        cart.setProducts(discountedList);
    }
}
