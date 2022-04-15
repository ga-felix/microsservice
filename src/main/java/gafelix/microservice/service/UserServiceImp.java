package gafelix.microservice.service;

import gafelix.microservice.exception.UserNotFoundException;
import gafelix.microservice.model.User;
import gafelix.microservice.repository.UserRepository;
import gafelix.microservice.service.dto.UserDto;
import gafelix.microservice.service.form.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.lang.String.*;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public User save(UserForm userForm) {
        return userRepository.save(userForm.toUser());
    }

    public void deleteById(Long id) throws UserNotFoundException {
        userRepository.findById(id).orElseThrow(
                () -> new UsernameNotFoundException(
                        format("User with %s id not found.", id)));
        userRepository.deleteById(id);
    }

    public UserDto findById(Long id) throws UserNotFoundException {
        var userEntity = userRepository.findById(id).orElseThrow(
                        () -> new UsernameNotFoundException(
                                format("User with %s id not found.", id)));
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getAddress(),
                userEntity.getCpf(),
                userEntity.getPis());
    }

}