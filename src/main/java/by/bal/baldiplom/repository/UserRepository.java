package by.bal.baldiplom.repository;

import by.bal.baldiplom.enity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
