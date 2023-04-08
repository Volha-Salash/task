package by.salash.task.service.impl;

import by.salash.task.entity.Users;
import by.salash.task.repository.UserRepository;
import by.salash.task.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author : Volha Salash
 */
@Log4j2
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<Users> findAll(Pageable pageable) throws InterruptedException {
        Thread.sleep(1000);
        log.info("All users found");
        return userRepository.findAll(pageable);
    }

    @Override
    public Users getUserById(Long uuid) throws InterruptedException {
        Optional<Users> optUser = userRepository.findById(uuid);
        Thread.sleep(1000);
        log.info("User with required id found");
        return optUser.get();
    }

    @Override
    public Long saveUser(Users users) throws InterruptedException {
        Users savedUser = userRepository.save(users);
        Thread.sleep(1000);
        log.info("User" + " " + users.getUsername() + " Saved Successfully with Id " + users.getId());
        return savedUser.getId();
    }

    @Override
    public String updateUser(Long id, String state) throws InterruptedException {
        try {
            userRepository.findById(id).ifPresent(
                    user -> {
                        user.setState(state);
                        userRepository.save(user);
                    }
            );
        } catch (Exception ex) {
            return "Error updating the user: " + ex;
        }
        Thread.sleep(1000);
        log.info("User new state: " + state + " - User successfully updated!");
        return "User id: " + Optional.of(id) + "New state: " + state + " - User successfully updated!";
    }

}

