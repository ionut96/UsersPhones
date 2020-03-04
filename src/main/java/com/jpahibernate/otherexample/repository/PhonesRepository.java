package com.jpahibernate.otherexample.repository;

import com.jpahibernate.otherexample.model.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository extends JpaRepository<Phones,Integer> {
}
