package org.example.service;

import org.example.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Str2ke
 * @date : 2024/1/18 下午11:59
 * @Desc :
 */
@Component
public interface UserService {

    List<User> getUser();

    List<User> getUser1(Integer id);
}
