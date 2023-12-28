package project.kafka.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingList {

	private String movieId;
	private String movieName;
	private String rating;
	
//	@JsonIgnore
	private RatingVO ratingVO = new RatingVO();
	
	public RatingVO getRatingVO() {
		return ratingVO;
	}
	public void setRatingVO(RatingVO ratingVO) {
		this.ratingVO = ratingVO;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
}
