package com.heaven.webservice.controller;

import com.heaven.webservice.service.UserService;
import com.heaven.webservice.user.User;
import com.heaven.webservice.user.UserDaoService;
import com.heaven.webservice.user.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("jpa/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<User>> retrievedAllUsers(){
        return ResponseEntity.ok(userService.findAll());
    }
    @GetMapping("/{id}")
    public EntityModel<User> getOne(@PathVariable("id") Integer id){
        User user = userService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id: "+id);
        }
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrievedAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@Valid @RequestBody User user){
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
}
