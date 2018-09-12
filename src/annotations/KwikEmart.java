package annotations;

import java.util.List;

public class KwikEmart {

    @HtmlElement(type = HTMLType.UL) private List<Product> products;

    public KwikEmart(List<Product> products) {
        super();
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
    
}
