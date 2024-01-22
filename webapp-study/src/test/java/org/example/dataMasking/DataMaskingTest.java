package org.example.dataMasking;

import org.example.Main;
import org.example.config.DataMaskingProperties;
import org.example.controller.TestController;
import org.example.utils.DataMaskingDecryptUtil;
import org.example.utils.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author : Str2ke
 * @date : 2024/1/22 下午11:07
 * @Desc :
 */
@SpringBootTest(classes = Main.class)
@RunWith(SpringRunner.class)
public class DataMaskingTest {

    @Test
    public void testMasking() throws Exception {
        byte[] encrypt = DataMaskingDecryptUtil.encrypt("abc");
        String s = DataMaskingDecryptUtil.bytesToHex(encrypt);
        System.out.println(s);
        System.out.println(DataMaskingDecryptUtil.decrypt(s));
    }
    @Test
    public void test1() {
        DataMaskingProperties bean = SpringUtils.getBean(DataMaskingProperties.class);
        System.out.println(bean.getClass().getName());
        String km = bean.getValue("MY");
        System.out.println(km);
        System.out.println("test");
    }

    @Test
    public void genMY() throws UnsupportedEncodingException {
        String salt = DataMaskingDecryptUtil.getSalt("123456");
        System.out.println(salt.length());
        System.out.println(salt);
    }

}
