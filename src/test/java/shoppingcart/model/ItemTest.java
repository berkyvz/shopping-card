package shoppingcart.model;

import org.junit.Test;
import shoppingcart.model.Item;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test class of the Item.
 *
 * @see shoppingcart.model.Item
 */
public class ItemTest {

    /**
     * Tests getters method and UUID pattern.
     */
    @Test
    public void testIdPattern() {
        String title = "test-title";
        Item item = new Item(title);
        //b8cf2ce6-2ecc-450c-b114-ce5c02a70978
        assertEquals(item.getTitle(), title);
        assertTrue(item.getId().matches("[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}"));
    }
}
