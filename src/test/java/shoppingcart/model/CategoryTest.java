package shoppingcart.model;


import org.junit.Test;
import shoppingcart.exception.NestedCategoryException;
import shoppingcart.model.Category;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Unit test class of the Category.
 *
 * @see shoppingcart.model.Category
 */
public class CategoryTest {


    /**
     * Tests overrode equals method - Success case.
     */
    @Test
    public void testEqualsSuccess() {
        Category category1 = new Category("Category1");
        Category category2 = new Category("Category2");
        category2.setId(category1.getId());
        assertEquals(category1, category2);
    }

    /**
     * Tests overrode equals method - Fail case.
     */
    @Test
    public void testEqualsFailure() {
        Category category1 = new Category("Category1");
        Category category2 = new Category("Category2");
        assertNotEquals(category1, category2);
    }

    /**
     * Tests overrode equals method - Fail case.
     */
    @Test
    public void testEqualsFailureObj() {
        Category category1 = new Category("Category1");
        String test = "test";
        assertNotEquals(category1, test);
    }

    /**
     * Tests getters method.
     */
    @Test
    public void gettersTest() throws NestedCategoryException {
        String title = "Category1";
        Category category1 = new Category(title);
        Category category2 = new Category("Category2");
        category1.setParent(category2);
        assertEquals(category1.getParent(), category2);
        assertFalse(category2.getId().isBlank());
        assertEquals(0, category1.getChildrenList().size());
        assertEquals(category1.getTitle(), title);
    }

    /**
     * Tests setter method;
     */
    @Test
    public void settersTest() throws NestedCategoryException {
        String id = UUID.randomUUID().toString();
        String title = "Category1";
        Category category1 = new Category("TEST");
        Category category2 = new Category("Category2");
        category1.setId(id);
        category1.setParent(category2);
        category1.setChildrenList(null);
        category1.setTitle(title);
        assertNull(category1.getChildrenList());
        assertEquals(category1.getTitle(), title);
        assertEquals(category1.getParent(), category2);
    }


}
