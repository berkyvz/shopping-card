package shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

public class Category extends Item {

    private Category parent;
    private List<Category> childrenList;

    public Category(String title) {
        super(title);
        this.childrenList = new ArrayList<>();
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Category> childrenList) {
        this.childrenList = childrenList;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Category) {
            return ((Category) obj).getId().equals(this.getId());
        }
        return false;
    }
}
