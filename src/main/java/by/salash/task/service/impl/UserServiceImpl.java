package by.salash.task.service.impl;

import by.salash.task.entity.Users;
import by.salash.task.exceptions.NotFoundException;
import by.salash.task.repository.UserRepository;
import by.salash.task.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Users getUserById(Long id) throws InterruptedException {
        Optional<Users> optUser = userRepository.findById(id);
        if (userRepository.findById(id)  == null) {
            throw new NotFoundException("User with this id does not exist");
        }
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
    public Optional<Users> updateUser(Long id, String state) {
        if (userRepository.findById(id)  == null) {
            throw new NotFoundException("User with this id does not exist");
        }
        return userRepository.findById(id)
                .map(user -> {
                    user.setState(state);
                    log.info("User id " + user.getId() + " with new state " + user.getState() + " update successfully");

                    // Save and return updated user object
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return userRepository.save(user);
                });
    }

}


