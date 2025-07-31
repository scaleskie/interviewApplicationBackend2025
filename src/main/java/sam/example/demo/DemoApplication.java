package sam.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
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
				"(1, 'TESLA', 'Tesla', 'Vehicle', '2'), " +
				"(2, 'FORD', 'Ford', 'Vehicle', '3')," +
				"(3, 'JEEP', 'Jeep', 'Vehicle', '7')," +
				"(4, 'CIVIC', 'Civic', 'Vehicle', '9')," +
				"(5, 'KIA', 'Kia', 'Vehicle', '3')," +
				"(6, 'TOYOTA', 'Toyota', 'Vehicle', '1')";


		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("New rows have been inserted into the items table.");
		}

		String eventSQL = "INSERT INTO events (id, name, type) VALUES" +
				"(1, 'Frank', 'WEDDING')," +
				"(2, 'Jim', 'BIRTHDAY')," +
				"(3, 'Elsa', 'FUNDRAISER')," +
				"(4, 'Amy', 'OTHER')," +
				"(5, 'Todd', 'BIRTHDAY')," +
				"(6, 'Fred', 'WEDDING')," +
				"(7, 'Joe', 'GRADUATION')";


		int eventRows = jdbcTemplate.update(eventSQL);

		if (eventRows > 0) {
			System.out.println("New rows have been inserted into the events table.");
		}
	}
}
