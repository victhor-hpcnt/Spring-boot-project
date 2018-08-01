package com.spring.study.domain;


import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.*;


@Data
@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "recommendation_id", nullable = false)
    private  int recommendationId;

    public Clothes() {}

    public Clothes(String s, int id) {
        this.name = s;
        this.recommendationId = id;
    }


}
