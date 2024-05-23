package br.com.matteusmoreno.yellow_tech_backend_challenge.controller;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreateUserRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.response.UserDetailsResponse;
import br.com.matteusmoreno.yellow_tech_backend_challenge.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDetailsResponse> create(@RequestBody @Valid CreateUserRequest request, UriComponentsBuilder uriBuilder) {
        User user = userService.createUser(request);
        URI uri = uriBuilder.path("/users/create/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetailsResponse(user));
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<UserDetailsResponse> details(@PathVariable Long id) {
        User user = userService.userDetails(id);

        return ResponseEntity.ok(new UserDetailsResponse(user));
    }
}
