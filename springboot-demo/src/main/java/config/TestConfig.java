package config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // associa uma instancia de userRepository
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Seeding database...");
        
        // id vai ser gerado pelo banco de dados
        User u1 = new User(null, "Maria Ba", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Marcelo Ab", "marcelo@gmail.com", "966666666", "123456");

        // salvar no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
    }


}
