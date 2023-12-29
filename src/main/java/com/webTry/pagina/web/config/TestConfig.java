package com.webTry.pagina.web.config;

import com.webTry.pagina.web.entities.User;
import com.webTry.pagina.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired//injeta a dependencia
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Maria Brown","maria@gmail.com","9888888","123456");
        User u2 = new User(null,"Alex green","alex@gmail.com","9777777","123333");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
