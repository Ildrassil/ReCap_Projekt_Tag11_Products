package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ShopService {
    OrderRepo orderRepo = new OrderMapRepo(new HashMap<Integer, Order> ());
    ProductRepo productRepo = new ProductRepo();

    public void createOrder(Map<String, Integer> einkaufsZettel, String nameOfOrderer, String adress, int idOrder, String dateOfOrder) {

        List<Product> productList = new ArrayList<>();
       List <String> productNamesInStock = einkaufsZettel.keySet().stream()
                                                         .filter(product1 ->  productRepo.getSingleProduct(product1).size() >= 0)
                                                         .filter(product -> productRepo.getSingleProduct(product)
                                                                 .stream()
                                                                 .anyMatch(product2 -> product2.quantityProduct() >
                                                                         einkaufsZettel.get(product2.productName()))).toList();


        for (int i = 0; i < productNamesInStock.size(); i++) {
           productList.addAll(productRepo.getSingleProduct(productNamesInStock.get(i)));

        }

        List<Product> productListWithQuantity = productList.stream()
                                                           .map(product -> new Product(product.productName(),product.price(),product.productId(), einkaufsZettel.get(product.productName())))
                                                           .toList();
        Order order = new Order(nameOfOrderer,adress,idOrder,productListWithQuantity,dateOfOrder, OrderStatus.IN_BEARBEITUNG );
        orderRepo.addOrder(order);
        productRepo.decreaseStock(productListWithQuantity);



        System.out.println("Your order has been placed" + "\n" + "Your order ID is: " + order.idOrder() + "\n" + "Your order will be delivered to: " + order.address() + "\n" + "Your order date is: " + order.dateOfOrder() + "\n" + "Your order costs: " + order.priceOfOrder() + "€" + "\n" + "Your order contains: " + "\n" + order.productList().stream().map(product -> product.productName() + " " + product.quantityProduct() + "x").toList());


    }
    public void increaseStock(String productName, int quantity) {
        productRepo.increaseStock(productName, quantity);
    }

    public Logger getLogger() {
        return Logger.getLogger(ShopService.class.getName());
    }





}
