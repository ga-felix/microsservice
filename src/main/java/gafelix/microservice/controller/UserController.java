package gafelix.microservice.controller;

import gafelix.microservice.model.User;
import gafelix.microservice.service.UserService;
import gafelix.microservice.service.form.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<User> createUser(@RequestBody @Valid UserForm userForm) {
        var createdUser = userService.save(userForm);
        return ResponseEntity
                .created(URI.create("/user/" + createdUser.getId()))
                .body(createdUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

}