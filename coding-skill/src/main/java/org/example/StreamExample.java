package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Str2ke
 * @date : 2024/2/9 下午3:07
 * @Desc :
 */
public class StreamExample {

    public static List<Student> repo;
    static {
        repo = Arrays.asList(
                Student.builder().id("11").name("aa").build(),
                Student.builder().id("11").name("bb").build(),
                Student.builder().id("33").name("cc").build(),
                Student.builder().id("44").name("dd").build()
        );
    }

    public void test1() {
        //
    }
}
