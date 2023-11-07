package com.burghesialexandre.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.burghesialexandre.workshopmongo.domain.User;
import com.burghesialexandre.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    public void run(String... arg0) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "alex Brown", "alex@gmail.com");
        User a = new User(null, "alex Brown", "alex@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex,a));
    }

}
