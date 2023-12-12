package org.example;

import java.util.List;

public interface OrderRepo {

    void addOrder(Order order);
    void removeOrder(Order order);
    void removeAllOrder();
    Order getOneOrder(int id);
    List<Order> getOrders();
    List<Order> getOrdersByDate(String date);
    int sumOfAllOrders();
    int sumOfOrder(int id);



}
