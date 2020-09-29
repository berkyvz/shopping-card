package shoppingcart.model;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    List<Product> productList;

    public Shop(List<Product> productList) {
        this.productList = productList;
    }

    public Shop() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
