package bouguern.tuto.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import bouguern.tuto.demo.product.Product;
import bouguern.tuto.demo.product.ProductRepository;
import bouguern.tuto.demo.user.User;
import bouguern.tuto.demo.user.UserRepository;

@SpringBootTest
@EnableTransactionManagement
public class JpaMultipleDBIntegrationTest {
 
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional("db1TransactionManager")
    public void whenCreatingUser_thenCreated() {
        User user = new User();
        user.setUsername("John");
        user.setBirthDay(LocalDate.of(1993, 12, 06));
        user = userRepository.save(user);

        assertNotNull(userRepository.findById(user.getUserId()));
    }

    @Test
    @Transactional("db2TransactionManager")
    public void whenCreatingProduct_thenCreated() {
        Product product = new Product();
        product.setName("Book");
        product = productRepository.save(product);

        assertNotNull(productRepository.findById(product.getProductId()));
    }
}