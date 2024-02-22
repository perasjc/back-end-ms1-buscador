package com.unir.grupo15.peliculas.a_model.a1_pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "image")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "video_id")
    private int videoId;
    @Column(name = "url")
    private String url;
    @Column(name = "type")
    private String type;
    @Column(name = "width")
    private int width;
    @Column(name = "height")
    private int height;
    @Column(name = "extension")
    private String extension;
    @Column(name = "size")
    private String size;
    @Column(name = "image_key")
    private String imageKey;
}
