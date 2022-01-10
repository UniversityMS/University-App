package lv.unversityManagementSystem.controller;



import lv.unversityManagementSystem.login.PasswordGeneration;
import lv.unversityManagementSystem.login.UsernameGeneration;
import lv.unversityManagementSystem.model.Role;
import lv.unversityManagementSystem.model.User;
import lv.unversityManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> gelAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public List<User> addUser(@RequestBody User user){
        user.setUsername(UsernameGeneration.getUserUsername(user));
        user.setPassword(PasswordGeneration.generateRandomPassword(10));
       // user.setRole(Role.LECTURER);
        List<User> lst = new ArrayList<>();
        lst.add(user);
        return lst;
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
