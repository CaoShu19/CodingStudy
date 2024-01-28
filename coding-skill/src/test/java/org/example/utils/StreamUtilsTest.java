package org.example.utils;

import org.example.Student;
import org.junit.Test;
import utils.StreamUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author : Str2ke
 * @date : 2024/1/29 上午12:43
 * @Desc :
 */

public class StreamUtilsTest {

    @Test
    public void testStream() {
        List<Student> list = Arrays.asList(
                Student.builder().id("11").name("aa").build(),
                Student.builder().id("11").name("bb").build(),
                Student.builder().id("33").name("cc").build(),
                Student.builder().id("44").name("dd").build()
        );
        list.forEach(StreamUtils.consumerWithIndex((index, item) -> {
            System.out.println(index + ":" + item);
        }));
    }
}
