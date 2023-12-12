package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopService {
    OrderRepo orderRepo = new OrderListRepo();
    ProductRepo productRepo = new ProductRepo();

    public void createOrder(Map<String, Integer> einkaufsZettel, String nameOfOrderer, String adress, int idOrder, String dateOfOrder) {
       List<Product> productList = new ArrayList<>();
       List <String> productNamesInStock = einkaufsZettel.keySet().stream().filter(product1 ->  productRepo.getSingleProduct(product1).size() > 0).toList();

        for (int i = 0; i < productNamesInStock.size(); i++) {
           productList.addAll(productRepo.getSingleProduct(productNamesInStock.get(i)));

        }
        List<Product> productListWithQuantity = productList.stream().map(product -> new Product(product.productName(),product.price(),product.productId(), einkaufsZettel.get(product.productName()))).toList();
        Order order = new Order(nameOfOrderer,adress,idOrder,productListWithQuantity,dateOfOrder);
        orderRepo.addOrder(order);

        System.out.println(orderRepo);


    }
    public void removeOrder(){

    }


}
