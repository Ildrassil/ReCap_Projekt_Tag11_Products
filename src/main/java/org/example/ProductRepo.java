package org.example;

import java.util.ArrayList;
import java.util.List;

// Step 2: Implement the ProductRepo class with a list to store products.
//Step 3: Implement methods to add, remove, and get products (single product and all pro

public class ProductRepo {

    public List<Product> productList;


    public ProductRepo() {

        productList = new ArrayList<>();
        Product airpods = new Product("Airpods", 200, 1, 10);
        Product iphone = new Product("Iphone", 1300, 2, 20);
        Product macbook = new Product("Macbook", 2800, 3, 20);

        productList.add(airpods);
        productList.add(iphone);
        productList.add(macbook);
    }


    public void addProduct(Product product) {
        productList.add(product);

    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public boolean checkIfStockIsAvailable(Product product, int quantity) {

        if (product.quantityProduct() > quantity) {
            return true;
        }
        return false;
    }

    public List<Product> getSingleProduct(String productName) {

        return productList.stream().filter(product -> product.productName().equals(productName)).toList();
    }

    public List<Product> getAllProducts() {
        return productList;
    }

}





