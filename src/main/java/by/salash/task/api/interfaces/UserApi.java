package by.salash.task.api.interfaces;

import by.salash.task.entity.Users;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author : Volha Salash
 */
@Validated
public interface UserApi {

    @GetMapping("/api/users")
    @ApiOperation(value = "get All Users")
    ResponseEntity<Page<Users>> getAllUsers(@PageableDefault(sort = "username", direction = Sort.Direction.ASC, size = 10) @NotNull Pageable pageable) throws InterruptedException;


    @GetMapping("/api/users/{usersId}")
    @ApiOperation(value = "get User by ID")
    Users getUserById(@PathVariable(name = "usersId") @NotNull Long usersId) throws InterruptedException;

    @PostMapping("/api/users")
    @ApiOperation(value = "create a new User")
    ResponseEntity<Long> saveUser(@RequestBody @NotNull Users users) throws InterruptedException;

    @PutMapping("/api/users/{usersId}")
    @ApiOperation(value = "update user's status")
    ResponseEntity<String> updateUser(@RequestBody @NotNull Long usersId, @NotNull String state) throws InterruptedException;

}
