package temp_test;

import org.example.config.Config;
import org.example.controller.UserController;
import org.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : Str2ke
 * @date : 2024/1/18 下午11:56
 * @Desc :
 */
public class TempTest {

    @Test
    public void testConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        UserController bean = context.getBean(UserController.class);
//        System.out.println(bean.getUser());
        UserService bean1 = context.getBean(UserService.class);
        System.out.println(bean1.getUser1(11));
    }
}
