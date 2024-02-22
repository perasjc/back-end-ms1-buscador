package com.unir.grupo15.peliculas.a_model.a1_pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gender")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_gender")
    private String nameGender;

}
