package br.com.matteusmoreno.yellow_tech_backend_challenge.controller;

import br.com.matteusmoreno.yellow_tech_backend_challenge.entity.User;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.CreateUserRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.request.UpdateUserRequest;
import br.com.matteusmoreno.yellow_tech_backend_challenge.response.UserDetailsResponse;
import br.com.matteusmoreno.yellow_tech_backend_challenge.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/list")
    public ResponseEntity<Page<UserDetailsResponse>> list(@PageableDefault(size = 10, sort = "name") Pageable pageable) {
        Page<UserDetailsResponse> page = userService.listAllUsers(pageable);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<UserDetailsResponse> details(@PathVariable Long id) {
        User user = userService.userDetails(id);

        return ResponseEntity.ok(new UserDetailsResponse(user));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDetailsResponse> update(@RequestBody @Valid UpdateUserRequest request) {
        User user = userService.updateUser(request);

        return ResponseEntity.ok(new UserDetailsResponse(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
