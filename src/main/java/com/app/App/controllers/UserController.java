package com.app.App.controllers;

import com.app.App.entities.User;
import com.app.App.entities.UserDto;
import com.app.App.exceptions.UserNotFoundException;
import com.app.App.repositories.UserRepository;
import com.app.App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    User getUserById (Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PutMapping(value = "/update")
    User updateUser(@RequestBody UserDto newUser){
        return userRepository.findById(newUser.getId())
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setPassword(newUser.getPassword());
                    return userRepository.save(user);
                }).orElseThrow(() ->new UserNotFoundException(newUser.getId()));
    }

//    @DeleteMapping("/delete")
//    String deleteUser(Long id) {
//        if (!userRepository.existsById(id)){
//            throw new UserNotFoundException(id);
//        }
//        userRepository.deleteById(id);
//        return "User with id "+id+" has been deleted";
//    }
    @PostMapping("/create1")
    public String createUser(@RequestParam ("name")String name,
                              @RequestParam ("email")String email,
                              @RequestParam ("password")String password) {
      UserDto newDto = UserDto.builder()
              .name(name)
              .email(email)
              .password(password)
              .joined(LocalDate.now())
              .build();

      return userService.createUser(newDto);
    }
}
