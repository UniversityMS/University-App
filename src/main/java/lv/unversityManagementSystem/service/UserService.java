package lv.unversityManagementSystem.service;


import lv.unversityManagementSystem.exception.DataWithThisIdNotFoundException;
import lv.unversityManagementSystem.domain.User;
import lv.unversityManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id).orElseThrow(() -> new DataWithThisIdNotFoundException("User" +
                " by id " + id + " was not found!"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

}
