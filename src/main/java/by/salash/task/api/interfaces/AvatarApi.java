package by.salash.task.api.interfaces;

import by.salash.task.entity.Avatar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author : Volha Salash
 */
@RequestMapping("/api")
@Validated
public interface AvatarApi {

    // GET /api/users/:userId/avatars
    @GetMapping("/users/{userId}/avatars")
    @ResponseStatus(HttpStatus.OK)
    List<Avatar> getAll(@PathVariable("userId") @NotNull Long userId) throws InterruptedException;

    // POST /api/users/:userId/avatars
    @PostMapping("/users/{userId}/avatars")
    @ResponseStatus(HttpStatus.CREATED)
    Avatar create(@PathVariable("userId") @NotNull Long userId, @RequestBody Avatar newAvatar) throws InterruptedException;

    // GET /api/users/:userId/avatars/:id
    @GetMapping("/users/{userId}/avatars/{id}")
    ResponseEntity<?> getOne(@PathVariable("userId") @NotNull Long userId, @PathVariable("id") Long id) throws InterruptedException;

    // PUT /api/users/:userId/avatars/:id
    @PutMapping("/users/{userId}/avatars/{id}")
    ResponseEntity<?> updateOne(@PathVariable("userId") @NotNull Long userId, @PathVariable("id") Long id, @RequestBody Avatar newAvatar) throws InterruptedException;

    // DELETE /api/users/:userId/avatars/:id
    @DeleteMapping("/users/{userId}/avatars/{id}")
    void delete(@PathVariable("userId") @NotNull Long userId, @PathVariable("id") Long id) throws InterruptedException;
}
