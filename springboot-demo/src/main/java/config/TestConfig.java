package config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // associa uma instancia de userRepository
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Seeding database...");
        
        // id vai ser gerado pelo banco de dados
        User u1 = new User(null, "Maria Ba", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Marcelo Ab", "marcelo@gmail.com", "966666666", "123456");
        
        Order o1 = new Order(null, Instant.parse("2025-08-20T13:23:31.72Z"), u1);
        Order o2 = new Order(null, Instant.parse("2025-10-22T01:37:56.00Z"), u2);
        Order o3 = new Order(null, Instant.parse("2025-07-20T14:33:42.00Z"), u2);
        
        // salvar no banco de dados
        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }


}
