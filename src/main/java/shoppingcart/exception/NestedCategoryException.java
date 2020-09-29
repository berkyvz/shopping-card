package shoppingcart.exception;

import shoppingcart.model.Category;

public class NestedCategoryException extends Exception {

    public NestedCategoryException(Category category) {
        super(category.getTitle() + "is nested. ID:" + category.getId());
    }
}
