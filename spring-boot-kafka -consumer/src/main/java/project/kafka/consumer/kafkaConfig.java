package project.kafka.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import project.kafka.movies.Movies;

@EnableKafka
@Configuration
public class kafkaConfig {

	
	public ConsumerFactory<String, Movies> consumerFactory(){
		  Map<String,Object> config = new HashMap<>();
	        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
	        config.put(ConsumerConfig.GROUP_ID_CONFIG,"sample-group");
	        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	        return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),
	                new JsonDeserializer<>(Movies.class));
	    
	}
	
	   @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, Movies> kafkaListener(){
	        ConcurrentKafkaListenerContainerFactory<String, Movies> factory = new ConcurrentKafkaListenerContainerFactory<String, Movies>();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
}
