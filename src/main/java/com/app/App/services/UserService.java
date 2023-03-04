package com.app.App.services;

import com.app.App.entities.User;
import com.app.App.entities.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    String createUser(UserDto userDto);
}
