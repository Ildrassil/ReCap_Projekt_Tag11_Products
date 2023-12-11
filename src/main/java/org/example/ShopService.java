package org.example;

public class ShopService {

public void createOrder(Order order){
    OrderListRepo orderList = new OrderListRepo();
    if(order.productList().stream().allMatch(product -> product.quantityProduct() > 0)){

            orderList.addOrder(order);

        }
        else{
            System.out.println("Out of Stock");
        }

    }







}
}