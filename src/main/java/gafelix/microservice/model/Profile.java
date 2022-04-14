package gafelix.microservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Profile implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

}