package org.example;

import java.time.LocalDate;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your name: ");
        String userName = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Type your adress here (Street+ No. , ZIP-Code + City)");
        String adress = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("What do you want to order (Productname, Quantity; Other Product, Quantity): ");
        List<String> productList  = Arrays.stream(sc.nextLine().split(";")).toList();
        ShopService shopService = new ShopService();
        Map<String, Integer> productNames = new HashMap<>();
        for(int i = 0 ; i < productList.size(); i++){
            productNames.put(productList.get(i).split(",")[0],Integer.parseInt(productList.get(i).split(",")[1]));
        }
        String date = LocalDate.now().toString();
        Random randomID = new Random();

        int id = randomID.nextInt(1000);
        shopService.createOrder(productNames,userName,adress,id,date);

        sc.close();
















    }
}