package project.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.kafka.movies.Movies;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	KafkaTemplate<String, Movies> kafkaTemplate;
	private static final String TOPIC = "movie-review-test"; 
	
    @PostMapping(value = "/publish",consumes = {"application/json"},produces = {"application/json"}) 
	public ResponseEntity<Movies> sendMsgToKafkaTopic(@RequestBody Movies moviesList){
			kafkaTemplate.send(TOPIC, moviesList);
			System.out.println("successfully movies been produced--->"+ moviesList);
			return ResponseEntity.status(HttpStatus.OK).body(moviesList); 
	}
}
