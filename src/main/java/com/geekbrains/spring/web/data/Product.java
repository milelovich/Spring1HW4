package com.geekbrains.spring.web.data;

public class Product {
    private Long id;
    private String name;
    private Integer score;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public Product(Long id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }


    public Product() {
    }
}
