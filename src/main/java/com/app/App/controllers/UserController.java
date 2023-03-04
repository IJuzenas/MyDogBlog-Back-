package com.app.App.controllers;

import com.app.App.entities.UserDto;
import com.app.App.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/create")
    public String createNewUser(@RequestBody UserDto user){
        return userService.createUser(user);
    }

    @PostMapping("/register")
    public String registerNewUser(@RequestParam("name") String name,
                                  @RequestParam ("email")String email,
                                  @RequestParam ("password") String password) {
      UserDto newDto = UserDto.builder()
              .name(name)
              .email(email)
              .password(password)
              .build();

      return userService.createUser(newDto);
    }
}
