package annotations;

import java.util.ArrayList;
import java.util.List;

import htmlGenerator.HtmlGenerator;

public class Main {

    public static void main(String[] args) throws Exception {
        
        
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Krusty Os", 10));
        products.add(new Product("Slurpy squeeshe", 20));
        products.add(new Product("Buzz Cola", 5));
        products.add(new Product("Duff beer", 8));
        KwikEmart store = new KwikEmart("Kwik E Mart", "1" ,"Apu Nahasapeemapetilon", products);
        
        HtmlGenerator.run(store);
    }

}
