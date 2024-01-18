package org.example.service.impl;

import org.example.model.User;
import org.example.repo.UserRepo;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : Str2ke
 * @date : 2024/1/19 上午12:00
 * @Desc :
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> getUser() {
        List<User> list = Arrays.asList(
                User.builder().age(11).name("aa").build(),
                User.builder().age(11).name("bb").build(),
                User.builder().age(33).name("cc").build(),
                User.builder().age(44).name("dd").build()
        );
        return list;
    }

    @Override
    public List<User> getUser1(Integer id) {
        List<User> aa = userRepo.getUserFromRepo("aa");
        Map<Integer, User> collect = aa.stream().collect(Collectors.toMap(
                user -> user.getAge(),
                user -> user,
                (a, b) -> a
        ));
        return Collections.singletonList(collect.get(id));
    }

}
