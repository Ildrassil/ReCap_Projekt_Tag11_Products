package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepo{

        public List<Order> orders;

        public OrderListRepo() {

            orders = new ArrayList<>();
        }

        public void addOrder(Order order) {
            //if(checkIfStockIsAvailable(order)){
                orders.add(order);


            }
           // System.out.println("Out of Stock");



        public  void removeOrder(Order order) {

            orders.removeIf(order1 -> order1.idOrder() == order.idOrder());
        }

        public void removeAllOrder() {
            orders.removeAll(orders);

        }

        public Order getOneOrder(int id) {
            return orders.stream().filter(order -> order.idOrder() == id).findFirst().orElse(null);
        }

        public List<Order> getOrders() {
            return orders;
        }
        /*public boolean checkIfStockIsAvailable(Order order) {

          if(order.quantityOrder()<= order.product().quantityProduct()) {
            return true;
          }
          return false;
        }*/

        public List<Order> getOrdersByDate(String date) {
            return orders.stream().filter(order -> order.dateOfOrder().equals(date)).toList();
        }

        public int sumOfAllOrders() {
            int sumOfAllOrders = orders.stream().mapToInt(order -> order.productList().stream().mapToInt(product -> product.price()).sum()).sum();
            return sumOfAllOrders;
        }
        public void sumOfOrder(int id) {
            int sumOfAllOrders = orders.stream().filter(order -> order.idOrder() == id).mapToInt(order -> order.productList().stream().mapToInt(product -> product.price()).sum()).sum();
            System.out.println(sumOfAllOrders);

        }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }
}
