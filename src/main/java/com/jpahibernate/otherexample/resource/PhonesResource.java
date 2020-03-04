package com.jpahibernate.otherexample.resource;

import com.jpahibernate.otherexample.model.Phones;
import com.jpahibernate.otherexample.model.Users;
import com.jpahibernate.otherexample.repository.PhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/rest/phones")
@RestController
public class PhonesResource {

    PhonesRepository phonesRepository;

    public PhonesResource(PhonesRepository phonesRepository){
        this.phonesRepository = phonesRepository;
    }

    @GetMapping("/all")
    public List<Phones> getPhones(){
        return phonesRepository.findAll();
    }

//    @GetMapping("/update/{brand}")
//    public List<Phones> update(@PathVariable("brand") final String brand){
//
//        Phones phones = new Phones();
//        phones.setBrand(brand)
//                .setModel(brand);
//
//        Users users = new Users();
//        users.setName("Ramona")
//                .setJob("Dadaca")
//                .setSalary(15423);
//
//        phones.setUsers(users);
//        phonesRepository.save(phones);
//        return phonesRepository.findAll();
//    }
}
