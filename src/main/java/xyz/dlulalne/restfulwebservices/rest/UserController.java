package xyz.dlulalne.restfulwebservices.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import xyz.dlulalne.restfulwebservices.dao.UserDaoService;
import xyz.dlulalne.restfulwebservices.exception.ErrorDetails;
import xyz.dlulalne.restfulwebservices.exception.UserNotFoundException;
import xyz.dlulalne.restfulwebservices.model.User;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class UserController {

    private final UserDaoService userDaoService;


    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable("id") int id){
        User user = userDaoService.findOne(id);
        if (user == null)
            throw new UserNotFoundException("User id not found: " + id);
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDaoService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }


}
