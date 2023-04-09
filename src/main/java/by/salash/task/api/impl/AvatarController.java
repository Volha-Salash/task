package by.salash.task.api.impl;

import by.salash.task.api.interfaces.AvatarApi;
import by.salash.task.entity.Avatar;
import by.salash.task.entity.Users;
import by.salash.task.repository.AvatarRepository;
import by.salash.task.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author : Volha Salash
 */

/**
 * class for processing User's avatars requests
 */
@RestController
@Log4j2
public class AvatarController implements AvatarApi {


    @Autowired
    private AvatarRepository avatarRepository;

    @Autowired
    private UserRepository userRepository;


    // GET /api/users/:userId/avatars
    @Override
    public List<Avatar> getAll(@PathVariable("userId") Long userId) throws InterruptedException {
        Thread.sleep(1000);
        log.info("REST request to get all Avatars with userId - {}", userId);
        return avatarRepository.findByUserId(userId);
    }

    // POST /api/users/:userId/avatars
    @Override
    public Avatar create(@PathVariable("userId") Long userId, @RequestBody Avatar newAvatar) throws InterruptedException {
        log.info("REST request to create an Avatar");
        Avatar model = new Avatar();
        Optional<Users> user = userRepository.findById(userId);
        model.setUser(user.get());
        model.setName(newAvatar.getName());
        Thread.sleep(1000);
        log.info("{}", model);
        return avatarRepository.save(model);
    }

    // GET /api/users/:userId/avatars/:id
    @Override
    public ResponseEntity<?> getOne(@PathVariable("userId") Long userId, @PathVariable("id") Long id) throws InterruptedException {
        log.info("REST request to get Avatar with id - {}", id);
        Optional<Avatar> model = null;
        model = avatarRepository.findByIdAndUserId(id, userId);
        if (model.isPresent()) {
            return new ResponseEntity<Avatar>(model.get(), HttpStatus.OK);
        }
        Thread.sleep(1000);
        return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
    }

    // PUT /api/users/:userId/avatars/:id
    @Override
    public ResponseEntity<?> updateOne(@PathVariable("userId") Long userId, @PathVariable("id") Long id, @RequestBody Avatar newAvatar) throws InterruptedException {
        log.info("REST request to update Avatar with id - {}", id);
        Optional<Avatar> model = null;
        model = avatarRepository.findByIdAndUserId(id, userId);
        if (model.isPresent()) {
            model.get().setName(newAvatar.getName());

            return new ResponseEntity<Avatar>(avatarRepository.save(model.get()), HttpStatus.OK);
        }
        Thread.sleep(1000);
        return new ResponseEntity<>("{}", HttpStatus.NOT_FOUND);
    }

    // DELETE /api/users/:userId/avatars/:id
    @Override
    public void delete(@PathVariable("userId") Long userId, @PathVariable("id") Long id) throws InterruptedException {
        Optional<Avatar> model = avatarRepository.findByIdAndUserId(id, userId);
        Thread.sleep(1000);
        avatarRepository.delete(model.get());
        log.info("Avatar deleted");
    }

}