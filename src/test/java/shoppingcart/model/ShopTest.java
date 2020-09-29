package shoppingcart.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test class of the Shop.
 *
 * @see shoppingcart.model.Shop
 */
public class ShopTest {

    /**
     * Tests getter methods of the model.
     */
    @Test
    public void testGetters() {
        Shop shop = new Shop();
        assertNotNull(shop.getProductList());
    }

    /**
     * Tests getter constructor.
     */
    @Test
    public void testConstructor() {
        Product product = new Product("product-1",5,new Category("category-1"));
        Shop shop = new Shop(Arrays.asList(product));
        assertEquals(1,shop.getProductList().size());
    }


    /**
     * Tests setter methods of the model.
     */
    @Test
    public void testSetters() {
        Shop shop = new Shop();
        Product product = new Product("product-1",5,new Category("category-1"));
        shop.setProductList(Arrays.asList(product));
        assertEquals(product,shop.getProductList().get(0));
    }
}
