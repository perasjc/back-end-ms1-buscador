package com.unir.grupo15.peliculas.b_data;

import com.unir.grupo15.peliculas.a_model.a1_pojo.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MoviesJpaRepository extends JpaRepository<Movies, Long>, JpaSpecificationExecutor<Movies> {
    List<Movies> findByTitle(String title);
    List<Movies> findBySynopsis(String synopsis);
    List<Movies> findByNumSeasonsLabel(String numSeasonsLabel);
    List<Movies> findByTitleAndReleaseYear(String title, int releaseYear);

}
