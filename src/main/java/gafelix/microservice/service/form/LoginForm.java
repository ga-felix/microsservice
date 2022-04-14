package gafelix.microservice.service.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public record LoginForm(
        String email,
        String password) {

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(this.email(), this.password());
    }

}