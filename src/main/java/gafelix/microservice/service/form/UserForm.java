package gafelix.microservice.service.form;

import gafelix.microservice.model.Address;
import gafelix.microservice.model.User;

import java.util.List;

public record UserForm(
        Long id,
        String name,
        String email,
        List<Address> address,
        String cpf,
        String pis,
        String password
) {

    public User toUser() {
        return new User(
                this.id,
                this.name,
                this.email,
                this.address,
                this.cpf,
                this.pis,
                this.password);
    }

}