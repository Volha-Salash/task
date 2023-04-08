package by.salash.task.repository;

import by.salash.task.entity.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author : Volha Salash
 */

/**
 * Interface extending JpaRepository interface for managing Avatars entities
 */
@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {

    List<Avatar> findByUserId(Long userId);

    Optional<Avatar> findByIdAndUserId(Long id, Long userId);
}
