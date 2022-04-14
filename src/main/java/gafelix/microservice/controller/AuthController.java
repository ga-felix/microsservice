package gafelix.microservice.controller;

import gafelix.microservice.security.jwt.JwtUtil;
import gafelix.microservice.service.dto.TokenDto;
import gafelix.microservice.service.form.LoginForm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm form) {
        UsernamePasswordAuthenticationToken login = form.convert();
        try {
            var authentication = authenticationManager.authenticate(login);
            var token = new TokenDto(jwtUtil.createToken(authentication), "Bearer");
            return ResponseEntity.ok(token);
        } catch(AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}