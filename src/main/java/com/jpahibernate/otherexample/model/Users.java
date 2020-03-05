package com.jpahibernate.otherexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Users", catalog = "TestProject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private Integer idUser;
    @Column(name = "name")
    private String name;
    private String job;
    @Column(name = "salary")
    private Integer salary;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "idUser",referencedColumnName = "id")
//    private Phones phone;
//
//    public Phones getPhone() {
//        return phone;
//    }
//
//    public void setPhone(Phones phone) {
//        this.phone = phone;
//    }

    public Users(){
    }


    public Users(@JsonProperty("name") String name,
                 @JsonProperty("job") String job,
                 @JsonProperty("salary") Integer salary){
        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    public Integer getId() {
        return idUser;
    }

    public Users setId(Integer id) {
        this.idUser = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Users setName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Users setJob(String job) {
        this.job = job;
        return this;
    }

    public Integer getSalary() {
        return salary;
    }

    public Users setSalary(Integer salary) {
        this.salary = salary;
        return this;
    }
}
