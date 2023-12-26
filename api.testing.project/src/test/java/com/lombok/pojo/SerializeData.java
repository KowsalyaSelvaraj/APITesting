package com.lombok.pojo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializeData {


	SuperHeroMoviesAndTVSeries heroMoviesAndTVSeries = new SuperHeroMoviesAndTVSeries();
	
	@Test
	public void convertJsonToPOJOViceVersa() throws StreamWriteException, DatabindException, IOException {
		heroMoviesAndTVSeries.setCategory("super hero moviesAndTVseries");

		List<String> acceptedFranchies= new ArrayList<String>();
		acceptedFranchies.add("DC");
		acceptedFranchies.add("Marvel");
		heroMoviesAndTVSeries.setAcceptedFranchises(acceptedFranchies);

		List<String> genresStrings = new ArrayList<String>();
		
		genresStrings.add("Action");
		genresStrings.add("Adventure");
		genresStrings.add("Heroic");
		genresStrings.add("Dark");
		genresStrings.add("Funny");
		
		heroMoviesAndTVSeries.setGenres(genresStrings);
		
		List<Movies> allMovies = new ArrayList<Movies>();

		Movies batmanMovies = new Movies();
		batmanMovies.setTitle("The Batman : The Dark Knight");
		batmanMovies.setYear(2008);

		List<String> batmanCastList = new ArrayList<String>();
		batmanCastList.add("Christian Bale");
		batmanCastList.add("Health Ledger");
		batmanMovies.setCast(batmanCastList);

		allMovies.add(batmanMovies);

		Movies advengersMovies = new Movies();
		advengersMovies.setTitle("Advengers : Age of Uetron");
		advengersMovies.setYear(2015);

		List<String> advengersMoviesList = new ArrayList<String>();
		advengersMoviesList.add("Roert Downey Jr.");
		advengersMoviesList.add("Chris Evans");
		advengersMovies.setCast(advengersMoviesList);

		allMovies.add(advengersMovies);

		Movies justiceMovies = new Movies();
		justiceMovies.setTitle("Justice League : Sydr Cut");
		justiceMovies.setYear(2011);

		List<String> justiceMoviesList = new ArrayList<String>();
		justiceMoviesList.add("Heandry Cavill");
		justiceMoviesList.add("Gal Gadot");
		justiceMovies.setCast(justiceMoviesList);

		allMovies.add(justiceMovies);

		Movies avengersMovies = new Movies();
		avengersMovies.setTitle("The Avengers");
		avengersMovies.setYear(2012);

		List<String> avengersMoviesList = new ArrayList<String>();
		avengersMoviesList.add("Chris Evans");
		avengersMoviesList.add("Chris Hemsworth");
		avengersMovies.setCast(avengersMoviesList);

		allMovies.add(avengersMovies);
		heroMoviesAndTVSeries.setMovies(allMovies);

		List<TVSeries> allTvSeries = new ArrayList<TVSeries>();

		TVSeries flashSeries = new TVSeries();

		flashSeries.setTitle("Flash");
		flashSeries.setYear(2014);

		TVSeries gothamSeries = new TVSeries();

		gothamSeries.setTitle("Gotham");
		gothamSeries.setYear(2014);

		TVSeries superGirlSeries = new TVSeries();

		superGirlSeries.setTitle("Super Girl");
		superGirlSeries.setYear(2015);

		allTvSeries.add(superGirlSeries);
		allTvSeries.add(flashSeries);
		allTvSeries.add(gothamSeries);

		heroMoviesAndTVSeries.setTvSeries(allTvSeries);

		OtherDetails otherDetails = new OtherDetails();

		otherDetails.setCountry("Only USA!! Engalukku veru engum kilaigal kidaiyathu!!");
		otherDetails.setLanguage("Aliens naalum english karanda");

		heroMoviesAndTVSeries.setOtherDetails(Arrays.asList(otherDetails));


		//serialize using Object Mapper
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("complex.json");
		mapper.writerWithDefaultPrettyPrinter().writeValue(file, heroMoviesAndTVSeries);

	}
}
