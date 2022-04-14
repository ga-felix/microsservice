package gafelix.microservice.service.dto;

import gafelix.microservice.model.Address;

import java.util.List;

public record UserDto(Long id,
                      String name,
                      String email,
                      List<Address> address,
                      String cpf,
                      String pis) {
}