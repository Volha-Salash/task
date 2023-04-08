package by.salash.task.api.impl;

import by.salash.task.api.interfaces.UserApi;
import by.salash.task.entity.Users;
import by.salash.task.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : Volha Salash
 */

/**
 * class for processing users requests
 */

@Log4j2
@RequiredArgsConstructor
@RestController
public class UserRestController implements UserApi {

    @Autowired
    private final UserService userService;

    @Override
    public ResponseEntity<Page<Users>> getAllUsers(Pageable pageable) throws InterruptedException {
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @Override
    public Users getUserById(@PathVariable(name = "usersId") Long usersId) throws InterruptedException {
        return userService.getUserById(usersId);
    }

    @Override
    public ResponseEntity<Long> saveUser(Users users) throws InterruptedException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(users));
    }

    @Override
    public ResponseEntity<String> updateUser(@RequestBody Long usersId, String state) throws InterruptedException {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(usersId, state));

    }
}