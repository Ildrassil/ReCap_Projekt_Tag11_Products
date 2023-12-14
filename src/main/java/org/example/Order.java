package org.example;


import java.util.List;


public record Order(
    String nameOfPersonOrdering,
    String address,
    int idOrder,
    List<Product> productList,
    int priceOfOrder,
    String dateOfOrder,
    OrderStatus status
) {
    public Order(String nameOfPersonOrdering, String address,int idOrder, List<Product> productList, String dateOfOrder, OrderStatus status) {
        this(nameOfPersonOrdering, address, idOrder, productList, productList.stream().mapToInt(product -> product.price()* product.quantityProduct()).sum(), dateOfOrder, status);
    }

        


}

