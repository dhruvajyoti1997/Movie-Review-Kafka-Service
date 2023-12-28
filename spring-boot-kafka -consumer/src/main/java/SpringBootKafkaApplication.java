import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
@ComponentScan(basePackages = { "project.kafka", "project.kafka.consumer"})
public class SpringBootKafkaApplication {

	public static void main(String[] args) {
		new  SpringApplication(SpringBootKafkaApplication.class).run(args);
	}

}
