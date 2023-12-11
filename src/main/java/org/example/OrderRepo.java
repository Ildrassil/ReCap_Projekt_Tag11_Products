package org.example;

import java.util.List;

public interface OrderRepo {
    void addOrder(Order order);
    void removeOrder(Order order);
    void removeAllOrder();
    List<Order> getOneOrder(int id);
    List<Order> getOrders();
    List<Order> getOrdersByDate(String date);
    int sumOfAllOrders();
    void sumOfOrder(int id);

}
