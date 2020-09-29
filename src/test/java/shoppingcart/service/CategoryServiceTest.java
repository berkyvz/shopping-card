package shoppingcart.service;

import org.junit.BeforeClass;
import org.junit.Test;
import shoppingcart.exception.NestedCategoryException;
import shoppingcart.model.Category;
import shoppingcart.service.impl.CategoryServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


/**
 * Test class of the Category Service.
 *
 * @see shoppingcart.service.impl.CategoryServiceImpl
 */
public class CategoryServiceTest {

    private static CategoryService categoryService;

    @BeforeClass
    public static void init() {
        categoryService = new CategoryServiceImpl();
    }

    /**
     * Test implemented sub-category operation - Success case.
     */
    @Test
    public void testAddSubCategory() throws NestedCategoryException {
        Category category1 = new Category("Category-1");
        Category category2 = new Category("Category-2");
        categoryService.applySubCategoryOperation(category1, category2);
        assertEquals(category2.getParent(), category1);
        assertEquals(category1.getChildrenList().get(0), category2);
    }

    /**
     * Test implemented sub-category operation - Exceptional Case.
     */
    @Test
    public void testAddSubCategoryExceptionalCase() throws NestedCategoryException {
        Category category1 = new Category("Category-1");
        Category category2 = new Category("Category-2");
        category1.setId(category2.getId());
        assertThrows(NestedCategoryException.class, () -> categoryService.applySubCategoryOperation(category1, category2));
    }

}
