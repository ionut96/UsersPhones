package com.jpahibernate.otherexample.resource;

import com.fasterxml.classmate.AnnotationConfiguration;
import com.jpahibernate.otherexample.model.Users;
import com.jpahibernate.otherexample.repository.UsersRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepos;

    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepos.findAll();
    }

//    @GetMapping("/{name}")
//    public List<Users> getUser(@PathVariable final String name){
//        Optional<List<Users>> listOptional = usersRepos.findByName(name);
//        List<Users> users = listOptional
//                .orElseThrow(()->new RuntimeException("RuntimeException GetMapping/{name} No users found."));
//                                        //.orElse(new ArrayList<>());
//        return users;
//    }

    @GetMapping("/{name}")
    public List<Users> getUserByName(@PathVariable("name") final String name) {
        return usersRepos.findByName(name);
    }

    @GetMapping("/id/{id}")
    public Users getUserById(@PathVariable("id") final Integer id) {
        return usersRepos.getOne(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Users updateNameById(@PathVariable("id") final Integer id, @PathVariable("name") final String name) {
        Users user = getUserById(id);
        user.setName(name);
        return usersRepos.save(user);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users users) {
        usersRepos.save(users);
        return "User " + users.getName() + " was saved";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") final Integer id) {
        usersRepos.deleteById(id);
        return "Deleted user with id:" + id;
    }

    @PutMapping("/id/{id}")
    public String updateFullUser(@PathVariable("id") final Integer id, @RequestBody Users user) {
        usersRepos.save(
                usersRepos
                        .getOne(id)
                        .setName(user.getName())
                        .setJob(user.getJob())
                        .setSalary(user.getSalary()));
        return "Change user with id " + id + " by PUT";
    }

    @PostMapping("/id/{id}")
    public String updateByPost(@PathVariable("id") final Integer id, @RequestBody Users user) {
        usersRepos.save(
                usersRepos
                        .getOne(id)
                        .setName(user.getName())
                        .setJob(user.getJob())
                        .setSalary(user.getSalary()));
        return "Change user with id " + id + " by POST";
    }


//    @GetMapping("/update/{brand}")
//    public List<Users> update(@PathVariable("brand") final String brand){
//
//        Phones phone = new Phones();
//        phone
//                .setBrand(brand)
//                .setModel("modelX");
//
//        Users user = new Users();
//        user
//                .setName("Danila")
//                .setJob("Bona")
//                .setSalary(64564)
//                .setPhone(phone);
//
//        usersRepos.save(user);
//        return usersRepos.findAll();
//    }
}
