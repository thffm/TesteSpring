package com.webTry.pagina.web.config;

import com.webTry.pagina.web.entities.Category;
import com.webTry.pagina.web.entities.Order;
import com.webTry.pagina.web.entities.User;
import com.webTry.pagina.web.entities.entities.num.OrderStatus;
import com.webTry.pagina.web.repositories.CategoryRepository;
import com.webTry.pagina.web.repositories.OrderRepository;
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


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }
}
