package com.cbfacademy.apiassessment;

import com.cbfacademy.apiassessment.controller.ProductController;
import com.cbfacademy.apiassessment.model.Product;
import com.cbfacademy.apiassessment.service.StockKeepingSystemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockKeepingSystemService stockKeepingSystemService;

    @Autowired
    private ObjectMapper objectMapper;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Test Product", "Description", BigDecimal.valueOf(10.5), 10, 20, "Category", "Supplier");
    }

    @Test
    void getAllProductsSuccess() throws Exception {
        given(stockKeepingSystemService.getAllProducts()).willReturn(Collections.singletonList(product));

        mockMvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(product.getName()));
    }

    @Test
    void getProductByIdSuccess() throws Exception {
        given(stockKeepingSystemService.getProductById(product.getId())).willReturn(java.util.Optional.of(product));

        mockMvc.perform(get("/api/products/{productId}", product.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(product.getName()));
    }

    @Test
    void addProductSuccess() throws Exception {
        given(stockKeepingSystemService.addProduct(product)).willReturn(product);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(product.getName()));
    }

    @Test
    void updateProductSuccess() throws Exception {
        given(stockKeepingSystemService.updateProduct(product.getId(), product)).willReturn(java.util.Optional.of(product));

        mockMvc.perform(put("/api/products/{productId}", product.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(product.getName()));
    }

    @Test
    void deleteProductSuccess() throws Exception {
        given(stockKeepingSystemService.deleteProduct(product.getId())).willReturn(true);

        mockMvc.perform(delete("/api/products/{productId}", product.getId()))
                .andExpect(status().isNoContent());
    }
}
