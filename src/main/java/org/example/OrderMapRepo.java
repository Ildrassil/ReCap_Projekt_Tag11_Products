package org.example;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrderMapRepo implements OrderRepo{

    Map<Integer, Order > orderMap;

    public OrderMapRepo(Map<Integer, Order> orderMap) {
        this.orderMap = orderMap;
    }

    @Override
    public void addOrder(Order order) {
        orderMap.put(order.idOrder(), order);

    }

    @Override
    public void removeOrder(Order order) {
        orderMap.remove(order.idOrder(),order);
    }

    @Override
    public void removeAllOrder() {
        orderMap.clear();

    }

    @Override
    public Order getOneOrder(int id) {
        return orderMap.get(id);

    }

    @Override
   public List<Order> getOrders() {
        return orderMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrdersByDate(String date) {
        return null;
    }

    @Override
    public int sumOfAllOrders() {
        return 0;
    }

    @Override
    public void sumOfOrder(int id) {

    }
}
