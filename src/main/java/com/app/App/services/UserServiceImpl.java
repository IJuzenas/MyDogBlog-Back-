package com.app.App.services;

import com.app.App.entities.User;
import com.app.App.entities.UserDto;
import com.app.App.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    public final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return mapToDto(userRepository.getAllUsers());
    }

    @Override
    public String createUser(UserDto userDto) {
        User newUser = buildNewUser(userDto);
        userRepository.save(newUser);
        return "New user has been created";
    }

    private User buildNewUser(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .joined(LocalDate.now())
                .build();

    }
    private List<UserDto> mapToDto(Collection<User> entities) {
        return entities.stream()
                .map(o -> UserDto.builder()
                        .id(o.getId())
                        .name(o.getName())
                        .email(o.getEmail())
                        .password(o.getPassword())
                        .build())
                .collect(Collectors.toList());
    }
}
