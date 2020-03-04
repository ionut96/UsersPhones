package com.jpahibernate.otherexample.repository;

import com.jpahibernate.otherexample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    //Optional<List<Users>> findByName(String name);
    List<Users> findByName(String name);
}
