package org.example.controller;

import org.example.model.UserAddress;
import org.example.repo.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Str2ke
 * @date : 2024/1/9 上午12:08
 * @Desc :
 */
@RestController
public class UserAddressController {
    @Autowired
    private UserAddressRepository userAddressRepository;

    @GetMapping(path = "/getAll2")
    public List<UserAddress> getAll2() {
        return userAddressRepository.findAll();
    }

    @GetMapping(path = "/getAll3")
    public List<UserAddress> getAll3() {
        UserAddress userAddress = new UserAddress();
        userAddress.setCity("xx");
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.startsWith())
                .withIgnorePaths("focus");
        Example<UserAddress> userAddressExample = Example.of(userAddress, exampleMatcher);

        return userAddressRepository.findAll(userAddressExample);
    }

}
