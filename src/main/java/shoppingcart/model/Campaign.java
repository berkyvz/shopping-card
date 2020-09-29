package shoppingcart.model;

public class Campaign extends Discount {

    private Category category;

    public Campaign(int discount, Category category) {
        super(discount);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
