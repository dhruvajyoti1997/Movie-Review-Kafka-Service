import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "project.kafka", "project.kafka.springbootkafka.producer"})
public class SpringBootKafkaApplication {

	public static void main(String[] args) {
		new  SpringApplication(SpringBootKafkaApplication.class).run(args);
	}

}
