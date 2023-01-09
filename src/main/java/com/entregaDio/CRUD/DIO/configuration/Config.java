package com.entregaDio.CRUD.DIO.configuration;

import com.entregaDio.CRUD.DIO.domain.entity.User;
import com.entregaDio.CRUD.DIO.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class Config implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        User user = new User(null,"Rudgge","rudgs86@gmail.com","235646");

        userRepository.save(user);
    }
}
