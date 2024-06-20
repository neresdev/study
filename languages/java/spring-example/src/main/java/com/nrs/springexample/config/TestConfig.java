package com.nrs.springexample.config;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nrs.springexample.entities.Category;
import com.nrs.springexample.entities.Order;
import com.nrs.springexample.entities.OrderItem;
import com.nrs.springexample.entities.Payment;
import com.nrs.springexample.entities.Product;
import com.nrs.springexample.entities.User;
import com.nrs.springexample.entities.enums.OrderStatus;
import com.nrs.springexample.repositories.CategoryRepository;
import com.nrs.springexample.repositories.OrderItemRepository;
import com.nrs.springexample.repositories.OrderRepository;
import com.nrs.springexample.repositories.ProductRepository;
import com.nrs.springexample.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@Profile("test")
@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner{
    
    private final UserRepository userRepository;

    private final OrderRepository orderRepository;

    private final CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    private final OrderItemRepository orderItemRepository;
    

    @Override
    public void run(String... args) throws Exception {
        
        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books"); 
        Category category3 = new Category(null, "Computers");

        Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
        Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
        Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
        Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
        Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(List.of(category1, category2, category3));
        productRepository.saveAll(List.of(product1, product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        productRepository.saveAll(List.of(product1, product2, product3, product4, product5));
        
        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", null);
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", null);

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.PAID); 
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAITTING_PAYMENT); 
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1, OrderStatus.WAITTING_PAYMENT); 

        userRepository.saveAll(List.of(user1, user2));
        orderRepository.saveAll(List.of(order1, order2, order3));

        OrderItem orderItem1 = new OrderItem(order1, product1, 2, product1.getPrice()); 
        OrderItem orderItem2 = new OrderItem(order1, product3, 1, product3.getPrice()); 
        OrderItem orderItem3 = new OrderItem(order2, product3, 2, product3.getPrice()); 
        OrderItem orderItem4 = new OrderItem(order3, product5, 2, product5.getPrice()); 
        
        orderItemRepository.saveAll(List.of(orderItem1, orderItem2, orderItem3, orderItem4));

        Payment payment1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
        order1.setPayment(payment1);

        orderRepository.save(order1);
    }    
}
