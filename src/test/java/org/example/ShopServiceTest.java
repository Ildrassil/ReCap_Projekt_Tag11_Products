package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Map;


class ShopServiceTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void createOrderTest_WhenWrongQuantityIsGiven_ThenProductDoesNotAppearInOrder() {
        ShopService shopService = new ShopService();
        shopService.createOrder(Map.of("Airpods", 30, "Macbook", 7, "Iphone", 8, "Ballala", 6), "Friedrich Schmitz", "Waldmannstraße 12, 60597 Frankfurt a.M., Deutschland", 5, "13-12-2023");
        assert shopService.orderRepo.getOneOrder(5).productList().stream().noneMatch(product -> product.productName().equals("Ballala"));
        assert shopService.orderRepo.getOneOrder(5).productList().stream().noneMatch(product -> product.productName().equals("Airpods"));
    }
}