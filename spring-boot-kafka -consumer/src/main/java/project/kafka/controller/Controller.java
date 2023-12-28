package project.kafka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.kafka.movies.Movies;
import project.kafka.movies.Rating;
import project.kafka.movies.RatingVO;
import project.kafka.service.kafkaConsumerService;

@RestController
@RequestMapping("/movie")
public class Controller {

	@Autowired
	private kafkaConsumerService service;

	@PostMapping(value = "/consumer", consumes = { "application/json" }, produces = { "application/json" })
	@KafkaListener(topics = "movie-review-test", groupId = "sample-group", containerFactory = "kafkaListener")
	public ResponseEntity<List<RatingVO>> ratingMovieFromProducer(Movies moviesList, @RequestBody Rating ratingList) {
		List<RatingVO> ratingVO = new ArrayList<>();
		if (ratingList != null) {
			service.rateMovie(ratingList, ratingVO, moviesList);
			return new ResponseEntity<List<RatingVO>>(ratingVO, HttpStatus.OK);
		}

		return new ResponseEntity<List<RatingVO>>(ratingVO, HttpStatus.NOT_FOUND);

	}
}
