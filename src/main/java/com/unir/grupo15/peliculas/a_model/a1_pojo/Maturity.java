package com.unir.grupo15.peliculas.a_model.a1_pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maturity")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Maturity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "maturity_level")
    private int maturityLevel;
    @Column(name = "maturity_description")
    private String maturityDescription;

}
