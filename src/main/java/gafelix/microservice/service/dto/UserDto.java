package gafelix.microservice.service.dto;

import gafelix.microservice.model.Address;
import gafelix.microservice.model.User;

import java.util.List;

public record UserDto(Long id,
                      String name,
                      String email,
                      List<Address> address,
                      String CPF,
                      String PIS,
                      String password) {

    public User toUser() {
        return new User(
                this.id,
                this.name,
                this.email,
                this.address,
                this.CPF,
                this.PIS,
                this.password);
    }

}