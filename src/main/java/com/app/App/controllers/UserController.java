package com.app.App.controllers;

import com.app.App.entities.UserDto;
import com.app.App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @PostMapping()
    public String createUser( String name,
                              String email,
                              String password) {
      UserDto newDto = UserDto.builder()
              .name(name)
              .email(email)
              .password(password)
              .joined(LocalDate.now())
              .build();

      return userService.createUser(newDto);
    }
}
