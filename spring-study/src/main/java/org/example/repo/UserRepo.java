package org.example.repo;

import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Str2ke
 * @date : 2024/1/19 上午12:29
 * @Desc :
 */
@Component
public class UserRepo {
    private static final List<User> userList;
    static {
         userList = Arrays.asList(
                User.builder().age(11).name("aa").build(),
                User.builder().age(11).name("bb").build(),
                User.builder().age(33).name("cc").build(),
                User.builder().age(44).name("dd").build()
        );
    }

    public List<User> getUserFromRepo(String name) {
        return userList;
    }
}
