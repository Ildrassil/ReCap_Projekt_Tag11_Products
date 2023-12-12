package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
    ShopService shopService = new ShopService();
    Map<String, Integer> productNames = new HashMap<>();
    productNames.put("Airpods", 2);
    productNames.put("Macbook", 5);
    productNames.put("Iphone", 4);
    productNames.put("Bal",6);
    shopService.createOrder(productNames,"Jakob Schneider","SachsenhäuserLandwehrweg 61, 60599 Frankfurt am Main",1,"12-12-2023");















    }
}