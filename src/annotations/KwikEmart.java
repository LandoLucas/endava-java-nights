package annotations;

import java.util.List;

import htmlGenerator.HTMLType;
import htmlGenerator.HtmlElement;

@HtmlElement(type = HTMLType.ROOT)
public class KwikEmart {

    @HtmlElement(type = HTMLType.H1) private String storeName;
    private String daysSinceLastRobbery;
    @HtmlElement(type = HTMLType.SPAN) private String storeOwner = "Apu";
    @HtmlElement(type = HTMLType.UL) private List<Product> products;
     
    public String getDaysSinceLastRobbery() {
        return daysSinceLastRobbery;
    }

    public void setDaysSinceLastRobbery(String daysSinceLastRobbery) {
        this.daysSinceLastRobbery = daysSinceLastRobbery;
    }

    public String getStoreOwner() {
        return storeOwner;
    }

    public void setStoreOwner(String storeOwner) {
        this.storeOwner = storeOwner;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public KwikEmart(String storeName, String daysSinceLastRobbery, String storeOwner, List<Product> products) {
        super();
        this.storeName = storeName;
        this.daysSinceLastRobbery = daysSinceLastRobbery;
        this.storeOwner = storeOwner;
        this.products = products;
    }

}
