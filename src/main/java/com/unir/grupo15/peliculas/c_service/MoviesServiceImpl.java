package com.unir.grupo15.peliculas.c_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatchException;
import com.github.fge.jsonpatch.mergepatch.JsonMergePatch;
import com.unir.grupo15.peliculas.a_model.a1_pojo.Movies;
import com.unir.grupo15.peliculas.a_model.a1_pojo.dto.MoviesDto;
import com.unir.grupo15.peliculas.b_data.MoviesRepository;
import com.unir.grupo15.peliculas.a_model.a2_request.MoviesRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class MoviesServiceImpl implements MoviesService {
    @Autowired
    private MoviesRepository repository;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public List<Movies> getMovies( String title, String synopsis, String numSeasonLabel) {
        if (StringUtils.hasLength(title) || StringUtils.hasLength(synopsis) || StringUtils.hasLength(numSeasonLabel)) {
            return repository.search(title, synopsis, numSeasonLabel);
        }
        List<Movies> movies = repository.getMovies();
        return movies.isEmpty() ? null : movies;
    }

    @Override
    public Movies getMovie(String movieId) {
        return repository.getById(Long.valueOf(movieId));
    }
    @Override
    public Boolean removeMovie(String movieId) {
        Movies movie = repository.getById(Long.valueOf(movieId));
        if (movie != null) {
            repository.delete(movie);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
    @Override
    public Movies createMovie(MoviesRequest request) {
        if (request != null && StringUtils.hasLength(request.getTitle().trim())
                && StringUtils.hasLength(request.getSynopsis().trim())
                && StringUtils.hasLength(request.getNumSeasonsLabel().trim())) {
            Movies movie = buildMovieFromRequest(request);
            if (movie != null) {
                return repository.save(movie);
            }
        }
        return null;
    }
    private Movies buildMovieFromRequest(MoviesRequest request) {
        if (request != null) {
            return Movies.builder()
                    .title(request.getTitle())
                    .synopsis(request.getSynopsis())
                    .releaseYear(request.getReleaseYear())
                    .numSeasonsLabel(request.getNumSeasonsLabel())
                    .gender(request.getGender())
                    .image(request.getImage())
                    .maturity(request.getMaturity())
                    .build();
        }
        return null;
    }
    @Override
    public Movies updateMovies(String movieId, MoviesDto updateRequest) {
        Movies movies = repository.getById(Long.valueOf(movieId));
        if (movies != null) {
            movies.update(updateRequest);
            repository.save(movies);
            return movies;
        } else {
            return null;
        }
    }
}
