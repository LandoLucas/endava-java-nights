package annotations;

@HtmlElement(type = HTMLType.LI)
public class Product {

    @HtmlElement(type = HTMLType.SPAN) private String name;
    @HtmlElement(type = HTMLType.SPAN) private int price;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    
    public Product(String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }
    
    
}
