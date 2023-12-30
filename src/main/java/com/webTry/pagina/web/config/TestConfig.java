package com.webTry.pagina.web.config;

import com.webTry.pagina.web.entities.Category;
import com.webTry.pagina.web.entities.Order;
import com.webTry.pagina.web.entities.Product;
import com.webTry.pagina.web.entities.User;
import com.webTry.pagina.web.entities.entities.num.OrderStatus;
import com.webTry.pagina.web.repositories.CategoryRepository;
import com.webTry.pagina.web.repositories.OrderRepository;
import com.webTry.pagina.web.repositories.ProductRepository;
import com.webTry.pagina.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired//injeta a dependencia automatico
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;//injection dependecy
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;



    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria Brown","maria@gmail.com","9888888","123456");
        User u2 = new User(null,"Alex green","alex@gmail.com","9777777","123333");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),u1, OrderStatus.PAID);
        Order o2 = new Order(null, Instant.parse("2019-07-20T03:42:10Z"),u2,OrderStatus.WAITING_PAYMENT);
        Order o3 = new Order(null, Instant.parse("2019-06-20T15:53:07Z"),u1,OrderStatus.WAITING_PAYMENT);

        Category c1 = new Category(null,"Electronics");
        Category c2 = new Category(null,"Books");
        Category c3 = new Category(null,"Computers");

        Product p1 = new Product(null,"The Lord of the Rings","Lorem ipsum dolor sit amet",90.5,"");
        Product p2 = new Product(null,"Smart Tv","Lorem ipsum dolor sit amet",2190.0,"");
        Product p3 = new Product(null,"Macbook Pro","Lorem ipsum dolor sit amet",1250.0,"");
        Product p4 = new Product(null,"Pc Gamer","Lorem ipsum dolor sit amet",1200.00,"");
        Product p5 = new Product(null,"Rails for Dummies","Lorem ipsum dolor sit amet",100.99,"");


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}
