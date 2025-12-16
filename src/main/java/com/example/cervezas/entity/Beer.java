package com.example.cervezas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "beers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cat_id")
    private Integer categoryId;

    @Column(name = "style_id")
    private Integer styleId;

    @Column(name = "abv")
    private Double abv;

    @Column(name = "ibu")
    private Double ibu;

    @Column(name = "glassware_id")
    private Integer glasswareId;

    @Column(name = "og")
    private Double og;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "last_mod")
    private String lastMod;

}

