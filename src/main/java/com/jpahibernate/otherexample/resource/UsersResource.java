package com.jpahibernate.otherexample.resource;

import com.jpahibernate.otherexample.model.Users;
import com.jpahibernate.otherexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity addUser(@RequestBody Users user, HttpServletResponse response) {

        if (user.getName().isEmpty())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User name is mandatory POST");

        if (usersRepos.findAll().stream()
                .anyMatch(u -> user.getName().toLowerCase().equals(u.getName().toLowerCase())))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User name " + user.getName() + " is already taken POST");

        usersRepos.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") final Integer id) {
        usersRepos.deleteById(id);
        return "Deleted user with id:" + id;
    }

    @PutMapping("/id/{id}")
    public ResponseEntity updateFullUser(@PathVariable("id") final Integer id, @RequestBody Users user) {

        if (user.getName().isEmpty())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User name is mandatory PUT");


        if (usersRepos.findAll().stream()
                .findFirst()
                .filter(u -> user.getName().toLowerCase().equals(u.getName().toLowerCase()))
                .filter(u -> u.getId() != id)
                .isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User name " + user.getName() + " is already taken PUT");

        usersRepos.save(
                usersRepos
                        .getOne(id)
                        .setName(user.getName())
                        .setJob(user.getJob())
                        .setSalary(user.getSalary()));

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

//    @PostMapping("/id/{id}")
//    public String updateByPost(@PathVariable("id") final Integer id, @RequestBody @NotNull Users user) {
//
//        if (!getUserByName(user.getName()).isEmpty()) {
//            return user.getName() + " username already exist";
//        }
//        usersRepos.save(
//                usersRepos
//                        .getOne(id)
//                        .setName(user.getName())
//                        .setJob(user.getJob())
//                        .setSalary(user.getSalary()));
//
//        return "Change user with id " + id + " by POST";
//    }


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
