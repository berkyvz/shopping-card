package shoppingcart.model;

public class Product extends Item {

    private double price;
    private Category category;

    public Product(String title, double price, Category category) {
        super(title);
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            return ((Product) obj).getId().equals(this.getId());
        }
        return false;
    }
}
