package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Str2ke
 * @date : 2024/1/19 上午12:03
 * @Desc :
 */

@Data
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping("/getUser")
    public Map<String, User> getUser() {
        return userService.getUser().stream().collect(
                Collectors.toMap(User::getName, user -> user, (a, b) -> a)
        );
    }
}
