package gafelix.microservice.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {

    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @OneToMany
    @NotNull
    private List<Address> address;
    @NotNull
    private String CPF;
    private String PIS;
    @NotNull
    private String password;

}
