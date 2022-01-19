package com.joeri.coffeebay;

import com.joeri.coffeebay.controllers.OrderController;
import com.joeri.coffeebay.model.Product;
import com.joeri.coffeebay.model.UserOrder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {
    @Autowired private OrderController orderController;

    
    @Test
    public void contextLoads() throws Exception {
        assertThat(orderController).isNotNull();
    }

    @Test
    public void createOrder() throws Exception {
        Product product = new Product(1L, "koffie");
        assertThat(orderController.create(product)).isNotNull();
    }
    @Test
    public void userOrderLoads() throws Exception {
        UserOrder userOrder = new UserOrder();
        assertThat(userOrder).isNotNull();
    }
}
