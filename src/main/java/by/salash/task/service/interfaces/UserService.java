package by.salash.task.service.interfaces;

import by.salash.task.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author : Volha Salash
 */

/**
 * interface with methods for suer business logic
 */
@Validated
public interface UserService {
    /**
     * finds all users
     *
     * @param pageable Pageable object for result pagination
     * @return page of UserWithoutPasswordDto object
     */
    Page<Users> findAll(@Valid Pageable pageable) throws InterruptedException;

    /**
     * find a user by id
     *
     * @param userId id of the user
     * @return found user
     */
    Users getUserById(@Valid Long userId) throws InterruptedException;

    /**
     * saves the user
     *
     * @param users User object to be saved
     * @return saved User object
     */
    Long saveUser(@Valid Users users) throws InterruptedException;


    /**
     * updates the user
     *
     * @param state String offline/online to be updated
     * @return updated user
     */
    Optional<Users> updateUser(@Valid Long id, String state);
}