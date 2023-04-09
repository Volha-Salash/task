package by.salash.task.api.interfaces;

import by.salash.task.entity.Users;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * @author : Volha Salash
 */
@Validated
public interface UserApi {

    @GetMapping("/api/users")
    @Operation(summary = "Get list of users (Ordered by username)")
    ResponseEntity<Page<Users>> getAllUsers(@PageableDefault(sort = "username", direction = Sort.Direction.ASC, size = 10) @NotNull Pageable pageable) throws InterruptedException;


    @GetMapping("/api/users/{usersId}")
    @Operation(summary = "Get User by ID")
    Users getUserById(@PathVariable(name = "usersId") @NotNull Long usersId) throws InterruptedException;

    @PostMapping("/api/users")
    @Operation(summary = "create a new User")
    ResponseEntity<Long> saveUser(@RequestBody @NotNull Users users) throws InterruptedException;


    @PutMapping("/api/users/{usersId}")
    @Operation(summary = "update user's status")
    ResponseEntity<Optional<Users>> updateUser(@PathVariable(name = "usersId") Long id, @RequestBody String state);

}
