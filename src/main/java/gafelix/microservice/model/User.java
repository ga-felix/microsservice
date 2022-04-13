package gafelix.microservice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {

    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @OneToMany
    @NotNull
    @Cascade(CascadeType.PERSIST)
    private List<Address> address;
    @NotNull
    private String CPF;
    private String PIS;
    @NotNull
    private String password;

}
