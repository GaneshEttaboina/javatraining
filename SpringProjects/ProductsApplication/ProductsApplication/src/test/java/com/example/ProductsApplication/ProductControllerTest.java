package com.example.ProductsApplication;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.ProductsApplication.Controllers.ProductController;
import com.example.ProductsApplication.Entities.Products;
import com.example.ProductsApplication.Repositories.ProductRepository;
 
 
@SpringBootTest
class ProductApplicationTests {
 
    @InjectMocks
    ProductController productController;
 
    @Mock
    ProductRepository repo;
 
    @Test
    void testAddProducts() {
        MockHttpServletRequest req = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));
 
        Products p = new Products(34, "colgate", "toothpaste", 10,
        LocalDate.of(2022, 8, 14));
       
        when(repo.save(any(Products.class)))
        .thenReturn(p);
 
        ResponseEntity<Products> R = productController.addProducts(p);
 
        assertThat(R.getStatusCode().equals(HttpStatus.CREATED));
    }
 
    @Test
    public void testFindAll() {
       
        Products p1 = new Products(35, "soap", "used for bathing",
        31, LocalDate.of(2019, 5, 13));
 
        Products p2 = new Products(47, "colgate", "toothpaste",
        10, LocalDate.of(2020, 7, 20));
 
        Products p3 = new Products(75, "chocolate", "food",
        5, LocalDate.of(2020, 3, 6));
 
        List<Products> products = new ArrayList<Products>();
 
        products.add(p1);
        products.add(p2);
        products.add(p3);
 
        when(repo.findAll()).thenReturn(products);
 
        List<Products> result = productController.getProducts();
 
        assertThat(result.size() == 3);
        assertThat(result.get(0).getName().equals(p1.getName()));
        assertThat(result.get(1).getName().equals(p2.getName()));
        assertThat(result.get(2).getName().equals(p3.getName()));
    }
 
}
