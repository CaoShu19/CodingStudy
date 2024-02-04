package org.example.controller;

import org.example.model.UserDemo;
import org.example.utils.JSONUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : Str2ke
 * @date : 2024/2/4 上午1:32
 * @Desc :
 */
@RestController
public class JsonController {

    @PostMapping("/user/json")
    public UserDemo list(@RequestBody UserDemo userDemo) {
        String jsonStr = JSONUtils.objectToJson(userDemo);
        userDemo.setCreateTime(new Date());
        userDemo.setLastLoginTime(new Date());
        System.out.println(jsonStr);
        return userDemo;
    }
}
