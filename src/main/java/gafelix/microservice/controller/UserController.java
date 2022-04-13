package gafelix.microservice.controller;

import gafelix.microservice.model.User;
import gafelix.microservice.service.UserService;
import gafelix.microservice.service.form.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(UserForm userForm) {
        var createdUser = userService.save(userForm);
        return ResponseEntity
                .created(URI.create("/" + createdUser.getId()))
                .body(createdUser);
    }

}