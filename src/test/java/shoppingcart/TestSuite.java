package shoppingcart;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import shoppingcart.model.*;
import shoppingcart.service.CategoryServiceTest;
import shoppingcart.service.DiscountServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CampaignTest.class,
        CartItemTest.class,
        CartTest.class,
        CategoryTest.class,
        CouponTest.class,
        ItemTest.class,
        ProductTest.class,
        ShopTest.class,
        CategoryServiceTest.class,
        DiscountServiceTest.class
})public class TestSuite
{
}
