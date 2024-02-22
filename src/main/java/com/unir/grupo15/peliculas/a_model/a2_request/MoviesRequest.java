package com.unir.grupo15.peliculas.a_model.a2_request;

import com.unir.grupo15.peliculas.a_model.a1_pojo.Gender;
import com.unir.grupo15.peliculas.a_model.a1_pojo.Image;
import com.unir.grupo15.peliculas.a_model.a1_pojo.Maturity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MoviesRequest {
    private int videoId;
    private int releaseYear;
    private String title;
    private String synopsis;
    private String numSeasonsLabel;
    private Gender gender;
    private Image image;
    private Maturity maturity;
}
