package gafelix.microservice.security.jwt;

import gafelix.microservice.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expiration;

    public String createToken(Authentication authentication) {
        User subject = (User) authentication.getPrincipal();
        Date now = new Date();
        return Jwts.builder()
                .setIssuer("Microservice")
                .setIssuedAt(now)
                .setSubject(subject.getId().toString())
                .setExpiration(new Date(now.getTime() + Long.parseLong(getExpiration())))
                .signWith(SignatureAlgorithm.HS256, getSecret())
                .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(this.getSecret()).build().parse(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(this.getSecret()).build().parseClaimsJws(token).getBody();
    }

}