package gafelix.microservice.service;

import gafelix.microservice.model.User;
import gafelix.microservice.service.dto.UserDto;
import gafelix.microservice.service.form.UserForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    User save(UserForm userForm);
    List<User> saveAll(List<UserForm> userForms);
    void deleteAllByNames(List<String> names);
    void deleteAllByCPF(List<String> cpfs);
    Page<User> findByNames(List<String> names, Pageable pageable);
    Page<User> findByCPF(List<String> cpfs, Pageable pageable);
    UserDto findById(Long id);

}