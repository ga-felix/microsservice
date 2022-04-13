package gafelix.microservice.service;

import gafelix.microservice.model.User;
import gafelix.microservice.repository.UserRepository;
import gafelix.microservice.service.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public User save(UserDto userDto) {
        return userRepository.save(userDto.toUser());
    }

    public void delete(UserDto userDto) {
        userRepository.delete(userDto.toUser());
    }

    public Page<User> findByNames(List<String> names, Pageable pageable) {
        return userRepository.findAllByNameIn(names, pageable);
    }

    public Page<User> findByCPF(List<String>  cpfs, Pageable pageable) {
        return userRepository.findAllByCPFIn(cpfs, pageable);
    }

}