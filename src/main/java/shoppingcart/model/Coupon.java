package shoppingcart.model;

public class Coupon extends Discount {

    private int minimumItemForDiscount;

    public Coupon(int discount, int minimumItemForDiscount) {
        super(discount);
        this.minimumItemForDiscount = minimumItemForDiscount;
    }

    public int getMinimumItemForDiscount() {
        return minimumItemForDiscount;
    }

    public void setMinimumItemForDiscount(int minimumItemForDiscount) {
        this.minimumItemForDiscount = minimumItemForDiscount;
    }
}
