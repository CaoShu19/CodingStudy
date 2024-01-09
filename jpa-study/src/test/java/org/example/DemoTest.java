package org.example;

import com.google.gson.Gson;
import org.example.model.Role;
import org.example.model.User;
import org.example.model.UserAddress;
import org.example.repo.UserAddressRepository;
import org.example.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Str2ke
 * @date : 2024/1/9 下午11:07
 * @Desc :
 */

/**
 * Springboot的@RunWith(SpringRunner.class)
 *
 * 注解的意义在于Test测试类要使用注入的类，比如@Autowired注入的类，
 *
 * 有了@RunWith(SpringRunner.class)这些类才能实例化到spring容器中，自动注入才能生效，
 *
 * 不然直接一个NullPointerExecption
 */
@SpringBootTest(classes = DemoApp.class)
@RunWith(SpringRunner.class)
public class DemoTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;
    @Test
    public void test1() {

        User user = new User();
        user.setName("jack");
        user.setEmail("111@xxx.xx");
        Role role = new Role();
        role.setRoleName("stu");
        user.setRole(role);

        userRepository.save(user);
    }

    @Test
    public void importTestData() {


        User user = new User();
        User user1 = new User();
        user.setName("jack");
        user.setEmail("111@xxx.xx");
        user1.setName("xm");
        user1.setEmail("222@xxx.xx");
        Role role = new Role();
        role.setRoleName("stu");
        user.setRole(role);
        user1.setRole(role);


        UserAddress userAddress = new UserAddress();
        userAddress.setCity("beijing");
        userAddress.setUser(user);
        user.setUserAddressesById(Arrays.asList(userAddress));
        user1.setUserAddressesById(Arrays.asList(userAddress));

        userRepository.save(user);
//        userAddressRepository.save(userAddress);

        List<User> all = userRepository.findAll();
        Gson gson = new Gson();
        gson.toJson(all);
    }
}
