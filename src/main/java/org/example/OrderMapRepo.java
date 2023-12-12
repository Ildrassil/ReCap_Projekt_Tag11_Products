package org.example;

import java.util.List;
import java.util.Map;
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
        return orderMap.values().stream().filter(order -> order.dateOfOrder().equals(date)).toList();
    }

    @Override
    public int sumOfAllOrders() {
        int sum =  orderMap.values().stream().mapToInt(order -> order.productList().stream().mapToInt(product -> product.price()).sum()).sum();
        System.out.println(sum);
        return sum;
    }

    @Override
    public int sumOfOrder(int id) {
        return orderMap.values().stream().filter( order -> order.idOrder() == id).mapToInt(Order::priceOfOrder).sum();

    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orderMap=" + orderMap +
                '}';
    }
}
