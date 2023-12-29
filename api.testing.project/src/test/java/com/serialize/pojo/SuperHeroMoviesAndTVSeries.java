package com.serialize.pojo;

import java.util.List;

public class SuperHeroMoviesAndTVSeries {

	
	private String category;
	private List<String> acceptedFranchises;
	private List<String> genres;
	
	private List<Movies> movies;
	private List<TVSeries> tvSeries;
	private List<OtherDetails> otherDetails;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getAcceptedFranchises() {
		return acceptedFranchises;
	}
	public void setAcceptedFranchises(List<String> acceptedFranchises) {
		this.acceptedFranchises = acceptedFranchises;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public List<Movies> getMovies() {
		return movies;
	}
	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}
	public List<TVSeries> getTvSeries() {
		return tvSeries;
	}
	public void setTvSeries(List<TVSeries> tvSeries) {
		this.tvSeries = tvSeries;
	}
	public List<OtherDetails> getOtherDetails() {
		return otherDetails;
	}
	public void setOtherDetails(List<OtherDetails> otherDetails) {
		this.otherDetails = otherDetails;
	}
	
	
 	
	
	
	
	
}
