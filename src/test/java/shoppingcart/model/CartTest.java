package shoppingcart.model;


import org.junit.Before;
import org.junit.Test;
import shoppingcart.model.Cart;
import shoppingcart.model.CartItem;
import shoppingcart.model.Category;
import shoppingcart.model.Product;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test class of the Cart.
 *
 * @see shoppingcart.model.Cart
 */
public class CartTest {

    private static List<CartItem> items;

    @Before
    public void init() {
        items = new ArrayList<>();
        CartItem item1 = new CartItem(new Product("product-1", 5.25, new Category("category-1")), 4);
        CartItem item2 = new CartItem(new Product("product-2", 2.65, new Category("category-2")), 2);
        items.add(item1);
        items.add(item2);
    }

    /**
     * Test of getter methods.
     */
    @Test
    public void testGetters() {
        Cart cart = new Cart(items);
        assertEquals(cart.getProducts().size(), items.size());
        assertEquals(cart.getProducts().get(0).getQuantity(), items.get(0).getQuantity());
    }

    /**
     * Test of setter methods.
     */
    @Test
    public void testSetters() {
        Cart cart = new Cart(items);
        cart.setProducts(new ArrayList<>());
        assertNotEquals(cart.getProducts().size(), items.size());
    }

}
