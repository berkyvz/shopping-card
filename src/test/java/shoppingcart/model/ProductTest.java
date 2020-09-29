package shoppingcart.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * Unit test class of the Product.
 *
 * @see shoppingcart.model.Product
 */
public class ProductTest {

    /**
     * Tests getter method.
     */
    @Test
    public void testGetters() {
        Category category = new Category("Category1");
        double price = 6;
        Product p = new Product("Product-1", price, category);
        assertEquals(p.getCategory(), category);
        assertEquals(p.getPrice(), price, 0.0);
    }

    /**
     * Tests setter method.
     */
    @Test
    public void testSetters() {
        Category category = new Category("Category1");
        double price = 6;
        String productTitle = "Product-2";
        Product p = new Product("Product-1", 0, null);
        p.setPrice(price);
        p.setCategory(category);
        p.setTitle(productTitle);
        assertEquals(p.getCategory(), category);
        assertEquals(p.getPrice(), price, 0.0);
    }

    /**
     * Tests equals method - Not Equals Case.
     */
    @Test
    public void testEquals() {
        Category category = new Category("Category1");
        double price = 6;
        Product p = new Product("Product-1", price, category);
        Product p2 = new Product("Product-1", price, category);
        assertNotEquals(p, p2);
    }

    /**
     * Tests equals method - Equals Case.
     */
    @Test
    public void testEqualsSuccess() {
        Category category = new Category("Category1");
        double price = 6;
        Product p = new Product("Product-1", price, category);
        Product p2 = new Product("Product-1", price, category);
        p2.setId(p.getId());
        assertEquals(p, p2);
    }

    /**
     * Tests equals method - No same object instance Case.
     */
    @Test
    public void testEqualsFailure() {
        Category category = new Category("Category1");
        double price = 6;
        Product p = new Product("Product-1", price, category);
        assertNotEquals(p, price);
    }

}
