package gafelix.microservice.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

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
    private Long streetNumber;
    private String extra;

}
