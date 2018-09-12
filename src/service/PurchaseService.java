package service;

import annotations.Product;

public class PurchaseService {

    public void purchase(Product product) {
        System.out.println("Buying product " + product.getName());
    }
    
}
