package project.kafka.movies;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Rating {
	 @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<RatingList> rating;

	public List<RatingList> getRatingList() {
		return rating;
	}

	public void setRatingList(List<RatingList> rating) {
		this.rating = rating;
	}
	 
	 
	
}
