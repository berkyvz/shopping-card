package shoppingcart.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test class of the Coupon.
 *
 * @see shoppingcart.model.Coupon
 */
public class CouponTest {

    /**
     * Tests getter methods of the model.
     */
    @Test
    public void testGetters() {
        int discount = 4;
        int minimumItem = 5;
        Coupon coupon = new Coupon(4,5);
        assertEquals(coupon.getMinimumItemForDiscount(),minimumItem);
        assertEquals(coupon.getRate(),discount);
    }

    /**
     * Tests setter methods of the model.
     */
    @Test
    public void testSetters() {
        int discount = 4;
        int minimumItem = 5;
        Coupon coupon = new Coupon(0,0);
        coupon.setMinimumItemForDiscount(minimumItem);
        coupon.setRate(discount);
        assertEquals(coupon.getMinimumItemForDiscount(),minimumItem);
        assertEquals(coupon.getRate(),discount);
    }
}
