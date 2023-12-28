package project.kafka.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesList {
	
    private String id;
	private String name;
	private String releasedYear;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReleasedYear() {
		return releasedYear;
	}
	public void setReleasedYear(String releasedYear) {
		this.releasedYear = releasedYear;
	}
	
	
	
	
}
