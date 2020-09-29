package shoppingcart.service;

import shoppingcart.exception.DiscountException;
import shoppingcart.model.Campaign;
import shoppingcart.model.Cart;
import shoppingcart.model.Coupon;
import shoppingcart.model.Shop;

/**
 * Adds discount feature.
 */
public interface DiscountService {

    /**
     * This method takes shop and campaign to apply discounts.
     *
     * @param shop     shop that needs to be discounted.
     * @param campaign campaign that will apply discount;
     */
    void applyCampaign(Shop shop, Campaign campaign) throws DiscountException;

    /**
     * This method takes cart and coupon to apply discounts.
     *
     * @param coupon shop that will apply discount;
     * @param cart   cart that needs to be discounted.
     */
    void applyCoupon(Coupon coupon, Cart cart) throws DiscountException;

}
