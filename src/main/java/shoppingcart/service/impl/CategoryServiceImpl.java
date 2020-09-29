package shoppingcart.service.impl;

import shoppingcart.exception.NestedCategoryException;
import shoppingcart.model.Category;
import shoppingcart.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public void applySubCategoryOperation(Category parent, Category category) throws NestedCategoryException {
        if (parent.equals(category)) {
            throw new NestedCategoryException(category);
        }
        parent.getChildrenList().add(category);
        category.setParent(parent);
    }
}
