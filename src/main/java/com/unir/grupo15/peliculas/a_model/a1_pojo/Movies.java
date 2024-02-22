package com.unir.grupo15.peliculas.a_model.a1_pojo;

import com.unir.grupo15.peliculas.a_model.a1_pojo.dto.MoviesDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "release_year")
    private int releaseYear;
    @Column(name = "title")
    private String title;
    @Column(name = "synopsis")
    private String synopsis;
    @Column(name = "num_seasons_label")
    private String numSeasonsLabel;

    @ManyToOne
    @JoinColumn(name = "id_gender")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "id_image")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "id_maturity")
    private Maturity maturity;

    public void update(MoviesDto moviesDto) {
        this.releaseYear = moviesDto.getReleaseYear();
        this.title = moviesDto.getTitle();
        this.synopsis = moviesDto.getSynopsis();
        this.numSeasonsLabel = moviesDto.getNumSeasonsLabel();
        this.gender = moviesDto.getGender();
        this.image = moviesDto.getImage();
        this.maturity = moviesDto.getMaturity();
    }
}
