package gafelix.microservice.service;

import gafelix.microservice.model.User;
import gafelix.microservice.service.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User save(UserDto userDto);
    void delete(UserDto userDto);
    Page<User> findByNames(List<String> names, Pageable pageable);
    Page<User> findByCPF(List<String> cpfs, Pageable pageable);

}