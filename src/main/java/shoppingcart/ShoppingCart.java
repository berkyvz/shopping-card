package shoppingcart;

import shoppingcart.exception.DiscountException;
import shoppingcart.exception.NestedCategoryException;
import shoppingcart.model.*;
import shoppingcart.service.CategoryService;
import shoppingcart.service.DeliveryService;
import shoppingcart.service.DiscountService;
import shoppingcart.service.impl.CategoryServiceImpl;
import shoppingcart.service.impl.DeliveryServiceImpl;
import shoppingcart.service.impl.DiscountServiceImpl;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * THIS CLASS IS NOT COVERED BECAUSE IT IS FOR TEST SCENARIO.
 */
public class ShoppingCart {

    private final static Logger LOGGER = Logger.getLogger(ShoppingCart.class.getName());

    public static void main(String[] args) {

        CategoryService categoryService = new CategoryServiceImpl();
        DiscountService discountService = new DiscountServiceImpl();
        DeliveryService deliveryService = new DeliveryServiceImpl();

        //Supermarket (1.Level)
        Category categorySuperMarket = new Category("SuperMarket");
        //Supermarket -> Pet Shop (2.Level)
        Category categorySupermarketPetShop = new Category("Pet Shop");
        //Supermarket -> Pet Shop -> Dog (3.Level)
        Category categorySupermarketPetShopDog = new Category("Dog");
        //Supermarket -> Pet Shop -> Cat (3.Level)
        Category categorySupermarketPetShopCat = new Category("Cat");
        //Supermarket -> Food (2.Level)
        Category categorySuperMarketFood = new Category("Food");
        //Supermarket -> Food -> Coffee (3.Level)
        Category categorySuperMarketFoodCoffee = new Category("Coffee");
        //Supermarket -> Food -> Tea (3.Level)
        Category categorySuperMarketFoodTea = new Category("Tea");

        try {
            categoryService.applySubCategoryOperation(categorySuperMarket, categorySupermarketPetShop);
            categoryService.applySubCategoryOperation(categorySuperMarket, categorySuperMarketFood);
            categoryService.applySubCategoryOperation(categorySupermarketPetShop, categorySupermarketPetShopCat);
            categoryService.applySubCategoryOperation(categorySupermarketPetShop, categorySupermarketPetShopDog);
            categoryService.applySubCategoryOperation(categorySuperMarketFood, categorySuperMarketFoodCoffee);
        } catch (NestedCategoryException e) {
            return;
        }

        //Products
        Product catFood5 = new Product("Cat Food 5kg", 110.0, categorySupermarketPetShopCat);
        Product catFood10 = new Product("Cat Food 10kg", 200.0, categorySupermarketPetShopCat);
        Product dogFood5 = new Product("Dog Food 5kg", 130.0, categorySupermarketPetShopDog);
        Product dogFood10 = new Product("Dog Food 10kg", 230.0, categorySupermarketPetShopDog);
        Product turkishCoffee500 = new Product("Turkish Coffee 500gr", 15.0, categorySuperMarketFoodCoffee);
        Product turkishCoffee1000 = new Product("Turkish Coffee 1000gr", 27.0, categorySuperMarketFoodCoffee);
        Product turkishTea500 = new Product("Tea 500gr", 8.0, categorySuperMarketFoodTea);
        Product turkishTea1000 = new Product("Tea 1000gr", 15.0, categorySuperMarketFoodTea);

        CartItem cartItem1 = new CartItem(catFood5, 2);
        CartItem cartItem2 = new CartItem(dogFood10, 1);
        CartItem cartItem3 = new CartItem(turkishCoffee1000, 1);
        CartItem cartItem4 = new CartItem(turkishTea500, 1);

        Shop shop = new Shop(Arrays.asList(catFood5, catFood10, dogFood5, dogFood10, turkishCoffee500, turkishCoffee1000, turkishTea500, turkishTea1000));
        //Product ( Category ) based discount. (Changes shop's product prices. Biggest scope
        try {
            discountService.applyCampaign(shop, new Campaign(25, categorySupermarketPetShopCat));
        } catch (DiscountException e) {
            e.printStackTrace();
        }


        //Cart based discount. (Never changes shop's product prices. Only effects products that is in cart)
        Coupon coupon = new Coupon(25, 10);
        Cart cart = new Cart(Arrays.asList(cartItem1, cartItem2, cartItem3, cartItem4));
        try {
            discountService.applyCoupon(coupon, cart);
        } catch (DiscountException e) {
            e.printStackTrace();
        }

        double cost = deliveryService.calculateDeliveryCost(cart);
        LOGGER.log(new LogRecord(Level.SEVERE, String.valueOf(cost)));


    }


}
