package com.spring.study.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name", nullable = false, unique=true)
    private String name;

    @Column(name = "recommendation_id", nullable = false)
    private  int recommendationId;

    public Long getId() {
        return  this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecommendationId(int recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getName() {
        return  this.name;
    }
    public int getRecommendationId() {
        return  this.recommendationId;
    }

    public Clothes() {}

    public Clothes(String s, int id) {
        this.name = s;
        this.recommendationId = id;
    }


}
