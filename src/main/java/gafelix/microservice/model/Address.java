package gafelix.microservice.model;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
public class Address implements Serializable {

    @Id @GeneratedValue
    private Long id;
    @NotNull
    private String country;
    @NotNull
    private String state;
    @NotNull
    private String county;
    @NotNull
    private String zipCode;
    @NotNull
    private String street;
    @NotNull
    private Long streetNumber;
    private String extra;

}