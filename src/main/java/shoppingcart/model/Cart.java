package shoppingcart.model;


import java.util.List;

public class Cart {

    private List<CartItem> products;

    public Cart(List<CartItem> products) {
        this.products = products;
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void setProducts(List<CartItem> products) {
        this.products = products;
    }

}
