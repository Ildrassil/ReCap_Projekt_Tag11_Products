package org.example;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public interface OrderRepo {

    void addOrder(Order order);
    void removeOrder(Order order);
    void removeAllOrder();
    Order getOneOrder(int id);
    List<Order> getOrders();
    List<Order> getOrdersByDate(String date);
    int sumOfAllOrders();
    void sumOfOrder(int id);

}
