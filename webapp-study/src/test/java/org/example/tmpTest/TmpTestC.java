package org.example.tmpTest;

import org.example.config.Config;
import org.example.model.TOrder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.misc.ObjectInputFilter;

/**
 * @author : Str2ke
 * @date : 2024/1/18 下午11:44
 * @Desc :
 */


public class TmpTestC {

    @Test
    public void testConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        TOrder bean = context.getBean(TOrder.class);
        System.out.println(bean.getName());
//        TOrder bean1 = context.getBean("getTOrder", TOrder.class);
//        System.out.println(bean1.getName());
        TOrder myBean = (TOrder)context.getBean("myBean");
        System.out.println(myBean.getName());
    }
}
