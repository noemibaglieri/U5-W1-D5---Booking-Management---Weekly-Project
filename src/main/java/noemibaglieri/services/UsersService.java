package noemibaglieri.services;

import lombok.extern.slf4j.Slf4j;
import noemibaglieri.entities.User;
import noemibaglieri.exceptions.NotFoundException;
import noemibaglieri.exceptions.ValidationException;
import noemibaglieri.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(User newUser) {

        if (usersRepository.existsByEmail(newUser.getEmail())) throw new ValidationException("Email: " + newUser.getEmail() + " is already in use.");

        if (usersRepository.existsByUsername(newUser.getUsername())) throw new ValidationException("The username * " + newUser.getUsername() + " * is already taken.");

        if (newUser.getUsername().length() < 4) throw new ValidationException("Username must be minimum 4 characters long.");

        usersRepository.save(newUser);

        log.info("The user * " + newUser.getFullName() + " * was successfully added to the database");
    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User findById(long userId) {
        return usersRepository.findById(userId).orElseThrow(() -> new NotFoundException(userId));
    }

    public void findByIdAndUpdate(long userId, User updatedUser) {
        User found = this.findById(userId);

        found.setFullName(updatedUser.getFullName());
        found.setEmail(updatedUser.getEmail());
        found.setUsername(updatedUser.getUsername());

        usersRepository.save(found);

        log.info("The user identified by * " + userId + " * was successfully edited.");
    }

    public void findByIdAndDelete(long userId) {
        User found = this.findById(userId);
        usersRepository.delete(found);
        log.info("The user identified by * " + userId + " * was successfully deleted.");
    }
}
