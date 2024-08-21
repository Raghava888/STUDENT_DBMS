package studentdbms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studentdbms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
