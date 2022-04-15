package gafelix.microservice.service;

import gafelix.microservice.exception.UserNotFoundException;
import gafelix.microservice.model.User;
import gafelix.microservice.service.dto.UserDto;
import gafelix.microservice.service.form.UserForm;

public interface UserService {

    User save(UserForm userForm);
    void deleteById(Long id) throws UserNotFoundException;
    UserDto findById(Long id)  throws UserNotFoundException;

}