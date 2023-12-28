package project.kafka.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import project.kafka.movies.Movies;
import project.kafka.movies.Rating;
import project.kafka.movies.RatingList;
import project.kafka.movies.RatingVO;

@Service
public class kafkaConsumerService {

	private static Map<Object, String> map = new HashMap<>();
	private static Map<Object, String> map2 = new HashMap<>();
	private static Map<Map<Object, String>, Map<Object, String>> map3 = new HashMap<>();

	private static List<String> mapId = new ArrayList<>();

	@KafkaListener(topics = "movie-review-test", groupId = "sample-group", containerFactory = "kafkaListener")
	public void consume(Movies movies) {
		StringBuilder sb = new StringBuilder();
		movies.getMovies().stream().forEach(s -> {

			map.put(movies, s.getId());
			map2.put(movies, sb.append(s.getId()).append(" ").append(s.getName()).append(" ")
					.append(s.getReleasedYear()).append(" ").toString());
			map3.put(map, map2);
			// System.out.println("Consumed Message :" + map2.get(movies));
			System.out.println(map.get(movies));
			for (Map.Entry<Object, String> entry : map.entrySet()) {
//				System.out.println(entry.getValue());
				mapId.add(entry.getValue());
			}
		});

	}

	public List<RatingVO> rateMovie(Rating rate, List<RatingVO> ratingVO, Movies moviesList) {
		if (!CollectionUtils.isEmpty(rate.getRatingList())) {
			for (RatingList rating : rate.getRatingList()) {
				if (mapId.contains(rating.getMovieId())) {
					rating.getRatingVO().setMovieName(rating.getMovieName());
					rating.getRatingVO().setRating(rating.getRating());

				}
				ratingVO.add(rating.getRatingVO());
			}

		}
		return ratingVO;

	}

}
