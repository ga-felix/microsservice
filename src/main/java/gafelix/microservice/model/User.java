package gafelix.microservice.model;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class User implements Serializable, UserDetails {

    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @NotNull
    private List<Address> address;
    @NotNull
    private String cpf;
    @NonNull
    private String pis;
    @NotNull
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Profile> authorities;

    public User(Long id, String name, String email, List<Address> address, String cpf, String pis, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.cpf = cpf;
        this.pis = pis;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

}
