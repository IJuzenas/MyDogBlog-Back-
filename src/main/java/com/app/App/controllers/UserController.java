package com.app.App.controllers;

import com.app.App.entities.UserDto;
import com.app.App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public String createUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @PostMapping("/create")
    public String createUser(@RequestParam(name = "name", required = false) String name,
                                  @RequestParam (value = "email",required = false) String email,
                                  @RequestParam (value = "password",required = false) String password) {
      UserDto newDto = UserDto.builder()
              .name(name)
              .email(email)
              .password(password)
              .build();

      return userService.createUser(newDto);
    }
}
