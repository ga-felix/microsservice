package gafelix.microservice.repository;

import gafelix.microservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAllByNameIn(List<String> names, Pageable pageable);
    Page<User> findAllByCpfIn(List<String> cpfs, Pageable pageable);

}