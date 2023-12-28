package project.kafka.movies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Movies {

	 @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<MoviesList> movies;

	public List<MoviesList> getMovies() {
		return movies;
	}

	public void setMovies(List<MoviesList> movies) {
		this.movies = movies;
	}
	
}
