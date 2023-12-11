package org.example;

import java.util.ArrayList;
import java.util.List;

// Step 2: Implement the ProductRepo class with a list to store products.
//Step 3: Implement methods to add, remove, and get products (single product and all pro

public class ProductRepo {

    public List<Product> productList;

    public ProductRepo() {
        productList = new ArrayList<>();
    }


    public void addProduct(Product product) {
        productList.add(product);

    }

    public void removeProduct(Product product) {
        productList.remove(product);
    }
    public boolean checkIfStockIsAvailable(Product product, int quantity) {

        if(product.quantityProduct()>quantity) {
            return true;
        }
        return false;
    }

    public List<Product> getSingleProduct(int id) {
        return productList.stream().filter(product -> product.productId() == id).toList();
    }

    public List<Product> getAllProducts() {
        return productList;
    }

}




