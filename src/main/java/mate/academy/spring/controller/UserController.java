package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserResponseMapper userResponseMapper;
    private final UserService userService;

    public UserController(UserResponseMapper userResponseMapper, UserService userService) {
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @GetMapping("/users/by-email")
    public UserResponseDto get(@RequestParam String email) {
        return userResponseMapper.toDto(userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Can't get user by email: " + email)));
    }
}
