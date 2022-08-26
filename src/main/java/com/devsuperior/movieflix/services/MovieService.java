package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	public MovieDTO findMovieById(Long id) {
		Optional<Movie> optional =  repository.findById(id);
		Movie movie =  optional.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		return new MovieDTO(movie, movie.getGenre());
	}
	
}
