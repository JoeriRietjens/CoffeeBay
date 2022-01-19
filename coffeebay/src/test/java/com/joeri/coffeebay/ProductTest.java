package com.joeri.coffeebay;
import com.joeri.coffeebay.model.Product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Test
    public void nameLoads() throws Exception {
        Product product = new Product();
        product.setName("jonny");
        assertThat(product.getName()).isNotNull();
    }
}

