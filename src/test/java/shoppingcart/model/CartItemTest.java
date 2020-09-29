package shoppingcart.model;


import org.junit.Test;
import shoppingcart.model.CartItem;
import shoppingcart.model.Category;
import shoppingcart.model.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test class of the CartItem.
 *
 * @see shoppingcart.model.CartItem
 */
public class CartItemTest {

    /**
     * Test of getter methods.
     */
    @Test
    public void testCartItemGetters() {
        int quantity = 4;
        Product p = new Product("test-product", 5, new Category("Category1"));
        CartItem cartItem = new CartItem(p, quantity);
        assertEquals(cartItem.getProduct(), p);
        assertEquals(cartItem.getQuantity(), quantity);
    }

    /**
     * Test of getter methods.
     */
    @Test
    public void testCartItemSetters() {
        int quantity = 4;
        Product p = new Product("test-product", 5, new Category("Category1"));
        CartItem cartItem = new CartItem(p, quantity);
        cartItem.setProduct(new Product("test-product-2", 1, new Category("Category2")));
        cartItem.setQuantity(quantity + 1);
        assertNotEquals(cartItem.getProduct(), p);
        assertNotEquals(cartItem.getQuantity(), quantity);
    }
}
