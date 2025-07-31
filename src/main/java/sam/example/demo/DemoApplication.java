package sam.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO items (id, code, name, category, quantity) VALUES" +
				"(1, 'car1', 'Tesla', 'Vehicle', '2'), " +
				"(2, 'car2', 'Ford', 'Vehicle', '3')," +
				"(3, 'car3', 'Jeep', 'Vehicle', '7')," +
				"(4, 'car4', 'Civic', 'Vehicle', '9')";

		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("New rows have been inserted.");
		}
	}
}
