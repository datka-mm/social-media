package peaksoft.repository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.exceptions.NotFoundException;
import peaksoft.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    default User getUserByEmail(String email) {
        return findByEmail(email).orElseThrow(() ->
                new NotFoundException("User not found")
        );
    }

    boolean existsByEmail(String email);
}
