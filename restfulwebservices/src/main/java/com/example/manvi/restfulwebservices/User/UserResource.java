package com.example.manvi.restfulwebservices.User;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import com.example.manvi.restfulwebservices.User.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    @Autowired
    MessageSource messageSource;

    @Autowired
    private UserDaoService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null)
            throw new UserNotFoundException("id-" + id);
        WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        EntityModel<User> model = EntityModel.of(user);
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = service.deleteById(id);

        if (user == null)
            throw new UserNotFoundException("id-" + id);
    }

    //
    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        // CREATED
        // /user/{id}     savedUser.getId()

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

//    @GetMapping("/users-internationalized")
//    public String usersInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
//        return messageSource
//                .getMessage("good.morning.message", null, "Default Message", locale);
//    }

    // Instead of accepting it as a parameter, we can use LocaleContextHolder.
    @GetMapping("/users-internationalized")
    public String usersInternationalized() {
        return messageSource
                .getMessage("good.morning.message", null, "Default Message", LocaleContextHolder.getLocale());
    }
}
