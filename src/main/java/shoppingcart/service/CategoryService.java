package shoppingcart.service;

import shoppingcart.exception.NestedCategoryException;
import shoppingcart.model.Category;

/**
 * Sub category feature interface.
 */
public interface CategoryService {

    /**
     * Adds category to category and handles child & parent processes.
     *
     * @param parent   parent-category
     * @param category sub-category
     */
    public void applySubCategoryOperation(Category parent, Category category) throws NestedCategoryException;

}
