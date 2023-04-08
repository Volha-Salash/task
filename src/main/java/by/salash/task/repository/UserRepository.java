package by.salash.task.repository;

import by.salash.task.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author : Volha Salash
 */

/**
 * Interface extending JpaRepository interface for managing Users entities
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
