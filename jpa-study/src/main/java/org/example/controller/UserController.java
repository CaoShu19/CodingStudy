package org.example.controller;

import com.google.gson.Gson;
import org.example.model.User;
import org.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Str2ke
 * @date : 2024/1/7 下午10:32
 * @Desc :
 */

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/getAll")
    public Page<User> getAllUserByPage() {
        return userRepository.findAll(PageRequest.of(1, 2, Sort.by("name")));
    }

    @Transactional
    @GetMapping(path = "/getTest")
    public Page<User> getTest(@RequestParam String name){
        Stream<User> userStream = userRepository.testQuery(name, PageRequest.of(1,2));
        Page<User> result = new PageImpl<>(new ArrayList<>());
        userStream.forEach(user -> {
            user.setName(user.getName() + "123");
            System.out.println(user);
            result.and(user);
        });
        return result;
    }

    @GetMapping(path = "/testEntityGraph")
    public List<User> getTest2(@RequestParam String name) {
        List<User> all = userRepository.findAll();
        all.forEach(x -> System.out.println(x.getEmail()));
        return all;
    }

    @GetMapping(path = "/testSPEL")
    public String getTest3(@RequestParam String name) {
        List<User> all = userRepository.testSpEL(name);
        return new Gson().toJson(all);
    }




}
