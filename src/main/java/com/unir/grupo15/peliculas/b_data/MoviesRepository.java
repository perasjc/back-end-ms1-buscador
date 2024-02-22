package com.unir.grupo15.peliculas.b_data;

import com.unir.grupo15.peliculas.a_model.a1_pojo.Movies;
import com.unir.grupo15.peliculas.b_data.b1_utils.SearchCriteria;
import com.unir.grupo15.peliculas.b_data.b1_utils.SearchOperation;
import com.unir.grupo15.peliculas.b_data.b1_utils.SearchStatement;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MoviesRepository {

    private final MoviesJpaRepository repository;

    public List<Movies> getMovies() {
        return repository.findAll();
    }

    public Movies getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Movies save(Movies movies) {
        return repository.save(movies);
    }

    public void delete(Movies movies) {
        repository.delete(movies);
    }

    public List<Movies> search(String title, String synopsis, String numSeasonLabel) {
        SearchCriteria<Movies> spec = new SearchCriteria<>();

        if (StringUtils.isNotBlank(title)) {
            spec.add(new SearchStatement("title", title, SearchOperation.MATCH));
        }

        if (StringUtils.isNotBlank(synopsis)) {
            spec.add(new SearchStatement("synopsis", synopsis, SearchOperation.EQUAL));
        }

        if (StringUtils.isNotBlank(numSeasonLabel)) {
            spec.add(new SearchStatement("numSeasonLabel", numSeasonLabel, SearchOperation.MATCH));
        }

        return repository.findAll(spec);
    }
}
