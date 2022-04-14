package gafelix.microservice.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User implements Serializable {

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
    private String pis;
    @NotNull
    private String password;

}
