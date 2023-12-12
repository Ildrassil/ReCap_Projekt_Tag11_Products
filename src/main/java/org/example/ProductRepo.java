package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void decreaseStock(List<Product> orderList) {
        List<Product> updatedProductList = new ArrayList<>(productList);

        for (Product orderProduct : orderList) {
            for (int i = 0; i < updatedProductList.size(); i++) {
                Product product = updatedProductList.get(i);
                if (product.productName().equals(orderProduct.productName())) {
                    int updatedQuantity = product.quantityProduct() - orderProduct.quantityProduct();
                    Product updatedProduct = new Product(product.productName(), product.price(), product.productId(), updatedQuantity);
                    updatedProductList.set(i, updatedProduct);
                }
            }
        }

        productList = updatedProductList;

        System.out.println("Incoming order has been updated to Stock");
        System.out.println("Stock now: " + productList);
    }

    public void increaseStock(String productName, int quantity) {
        List<Product> updatedProductList = new ArrayList<>(productList);

        for (int i = 0; i < updatedProductList.size(); i++) {
            Product product = updatedProductList.get(i);
            if (product.productName().equals(productName)) {
                int updatedQuantity = product.quantityProduct() + quantity;
                Product updatedProduct = new Product(product.productName(), product.price(), product.productId(), updatedQuantity);
                updatedProductList.set(i, updatedProduct);

            }

            productList = updatedProductList;

            System.out.println("Incoming order has been updated to Stock");
            System.out.println("Stock of " + productName + " now: " + productList);
        }


    }
}
