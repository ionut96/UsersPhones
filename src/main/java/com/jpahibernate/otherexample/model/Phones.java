package com.jpahibernate.otherexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Phones", catalog = "TestProject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPhone")
    private Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;

    public Integer getId() {
        return id;
    }

    public Phones setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public Phones setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Phones setModel(String model) {
        this.model = model;
        return this;
    }
}
