package shoppingcart.model;

import java.util.UUID;

public class Item {

    private String id;
    private String title;

    public Item(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
