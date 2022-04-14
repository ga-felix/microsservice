package gafelix.microservice.service;

import gafelix.microservice.model.User;
import gafelix.microservice.repository.UserRepository;
import gafelix.microservice.service.dto.UserDto;
import gafelix.microservice.service.form.UserForm;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public User save(UserForm userForm) {
        return userRepository.save(userForm.toUser());
    }

    public List<User> saveAll(List<UserForm> userForms) {
        return userRepository.saveAll(userForms
                .stream()
                .map(UserForm::toUser)
                .toList());
    }

    public void deleteAllByNames(List<String> names) {
        userRepository.deleteAllByNameIn(names);
    }

    public void deleteAllByCpf(List<String> cpfs) {
        userRepository.deleteAllByCpfIn(cpfs);
    }

    public Page<User> findByNames(List<String> names, Pageable pageable) {
        return userRepository.findAllByNameIn(names, pageable);
    }

    public Page<User> findByCpf(List<String>  cpfs, Pageable pageable) {
        return userRepository.findAllByCpfIn(cpfs, pageable);
    }

    @SneakyThrows
    public UserDto findById(Long id) {
        var userEntity = userRepository.findById(id).orElseThrow();
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getAddress(),
                userEntity.getCpf(),
                userEntity.getPis());
    }

}