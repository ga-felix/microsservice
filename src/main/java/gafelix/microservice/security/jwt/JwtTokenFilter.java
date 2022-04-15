package gafelix.microservice.security.jwt;

import gafelix.microservice.exception.UserNotFoundException;
import gafelix.microservice.model.User;
import gafelix.microservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.String.format;

@AllArgsConstructor
@Getter
public class JwtTokenFilter extends OncePerRequestFilter {

    private UserRepository userRepository;
    private JwtUtil jwtUtil;

    private void authenticate(String token) throws UserNotFoundException {
        Long id = Long.parseLong(this.getJwtUtil().getClaims(token).getSubject());
        User user = getUserRepository().findById(id).orElseThrow(
                () -> new UsernameNotFoundException(format("%s not found in JWT claim", id))
        );
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private boolean isAuthorizationMissing(String authorization) {
        return (authorization == null || authorization.isBlank() || !authorization.startsWith("Bearer "));
    }

    private String retrieveToken(String authorization) {
        if(isAuthorizationMissing(authorization)) return null;
        String tokenValue = authorization.substring(7);
        if(jwtUtil.isTokenValid(tokenValue)) return tokenValue;
        else return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = retrieveToken(request.getHeader("Authorization"));
        if(token != null) {
            authenticate(token);
        }
        filterChain.doFilter(request, response);
    }

}