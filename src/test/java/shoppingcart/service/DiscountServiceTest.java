package shoppingcart.service;

import org.junit.Before;
import org.junit.Test;
import shoppingcart.exception.DiscountException;
import shoppingcart.exception.NestedCategoryException;
import shoppingcart.model.*;
import shoppingcart.service.impl.CategoryServiceImpl;
import shoppingcart.service.impl.DeliveryServiceImpl;
import shoppingcart.service.impl.DiscountServiceImpl;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test class of the Discount Service.
 *
 * @see shoppingcart.service.impl.DiscountServiceImpl
 */
public class DiscountServiceTest {

    private static DiscountService discountService;
    private static Cart cart;
    private static Shop shop;
    private static Category parentCategory;

    @Before
    public void init() throws NestedCategoryException {
        discountService = new DiscountServiceImpl();

        parentCategory = new Category("SuperMarket");
        Category categorySupermarketPetShop = new Category("Pet Shop");
        Category categorySupermarketPetShopDog = new Category("Dog");
        Category categorySupermarketPetShopCat = new Category("Cat");
        CategoryService categoryService = new CategoryServiceImpl();
        Product catFood5 = new Product("Cat Food 5kg", 110.0, categorySupermarketPetShopCat);
        Product dogFood10 = new Product("Dog Food 10kg", 230.0, categorySupermarketPetShopDog);
        categoryService.applySubCategoryOperation(parentCategory, categorySupermarketPetShop);
        categoryService.applySubCategoryOperation(categorySupermarketPetShop, categorySupermarketPetShopCat);
        categoryService.applySubCategoryOperation(categorySupermarketPetShop, categorySupermarketPetShopDog);
        CartItem cartItem1 = new CartItem(catFood5, 2); //220
        CartItem cartItem2 = new CartItem(dogFood10, 1); //230
        shop = new Shop(Arrays.asList(catFood5, dogFood10));
        cart = new Cart(Arrays.asList(cartItem1, cartItem2));
    }

    /**
     * Test discount for cart with coupons. - Minimum item count is not satisfied.
     *
     * @throws DiscountException
     */
    @Test
    public void testDiscountCoupon() throws DiscountException {
        Coupon coupon = new Coupon(25, 10);
        Product p = cart.getProducts().get(0).getProduct();
        discountService.applyCoupon(coupon, cart);
        Product pAfterDiscount = cart.getProducts().get(0).getProduct();
        assertEquals(p.getPrice(), pAfterDiscount.getPrice(), 0.0);
    }

    /**
     * Test discount for cart with coupons. - Minimum item count is satisfied.
     *
     * @throws DiscountException
     */
    @Test
    public void testDiscountCouponSatisfied() throws DiscountException {
        Coupon coupon = new Coupon(50, 0);
        Product p = cart.getProducts().get(0).getProduct();
        discountService.applyCoupon(coupon, cart);
        Product pAfterDiscount = cart.getProducts().get(0).getProduct();
        assertEquals(p.getPrice() / 2, pAfterDiscount.getPrice(), 0.0);
    }

    /**
     * Test discount for cart with coupons. - discount is not valid.
     */
    @Test
    public void testDiscountCouponValidationError() {
        Coupon coupon = new Coupon(120, 0);
        assertThrows(DiscountException.class, () -> discountService.applyCoupon(coupon, cart));
    }

    /**
     * Tests discount for category with Campaign - Success case.
     * @throws DiscountException
     */
    @Test
    public void applyCampaignTest() throws DiscountException {
        int index = 0;
        int discount = 50;
        double priceBefore = shop.getProductList().get(index).getPrice();
        discountService.applyCampaign(shop,new Campaign(discount, parentCategory.getChildrenList().get(0)));
        double priceAfter = shop.getProductList().get(index).getPrice();
        assertEquals(priceBefore,priceAfter * 100 / discount,0.0);
    }

    /**
     * Tests discount for category with Campaign - Exceptional case.
     * @throws DiscountException
     */
    @Test
    public void applyCampaignTestException()  {
        int index = 0;
        int discount = 120;
        assertThrows(DiscountException.class, () -> discountService.applyCampaign(shop,new Campaign(discount, parentCategory.getChildrenList().get(0))));

    }

    /**
     * Tests deliver cost.
     */
    @Test
    public void testDeliveryCost(){
        DeliveryService deliveryService = new DeliveryServiceImpl();
        double cost = deliveryService.calculateDeliveryCost(cart);
        assertEquals(cost, 450, 0.0);
    }


}
