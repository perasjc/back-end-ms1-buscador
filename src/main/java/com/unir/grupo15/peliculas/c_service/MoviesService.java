package com.unir.grupo15.peliculas.c_service;

import com.unir.grupo15.peliculas.a_model.a1_pojo.Movies;
import com.unir.grupo15.peliculas.a_model.a1_pojo.dto.MoviesDto;
import com.unir.grupo15.peliculas.a_model.a2_request.MoviesRequest;

import java.util.List;

public interface MoviesService {
    List<Movies> getMovies(String title, String synopsis, String numSeasonLabel);
    Movies getMovie(String movieId);
    Boolean removeMovie(String movieId);
    Movies createMovie(MoviesRequest request);
    Movies updateMovies(String movieId, MoviesDto updateRequest);
}
