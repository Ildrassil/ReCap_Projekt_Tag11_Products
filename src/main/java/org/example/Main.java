package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    Product airpods = new Product("Airpods", 200,  1,10);
    Product iphone = new Product("Iphone", 1300, 2,20);
    Product macbook = new Product("Macbook", 2800, 3,20);

    ProductRepo productRepo = new ProductRepo();
    productRepo.addProduct(airpods);
    productRepo.addProduct(iphone);
    productRepo.addProduct(macbook);

    Order order1 = new Order("John", "Street 1", 1, Arrays.asList(airpods,airpods,macbook,
            macbook,iphone,iphone), "2023-12-10");


        System.out.println(productRepo.getSingleProduct(1));
        System.out.println(productRepo.getAllProducts());
        System.out.println(order1);


    }
}