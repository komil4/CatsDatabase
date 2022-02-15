package com.catsDB.models;

import com.catsDB.enums.CatColor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @Column(name = "name")
    private CatColor name;

    @Column(name = "cat_color")
    private CatColor color;

    @Column(name = "tail_length")
    private Integer tailLength;

    @Column(name = "whiskers_length")
    private Integer whiskersMean;
}
