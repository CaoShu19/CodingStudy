package org.example;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : Str2ke
 * @date : 2023/12/5 上午1:48
 * @Desc :
 */
public class ListToMap {


    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                Student.builder().id("11").name("aa").build(),
                Student.builder().id("11").name("bb").build(),
                Student.builder().id("33").name("cc").build(),
                Student.builder().id("44").name("dd").build()
        );
        /**
         * 关于 Collectors.toMap(key, value, key_strategy)
         */

        // method1
        Map<String, String> map1 = list.stream().collect(
                Collectors.toMap(
                        Student::getId,// 第一个方法引用为key
                        Student::getName, // 第二个方法引用为value
                        (key1, key2) -> key1 // 当出现key重复的时候,使用第一此出现的key
                ));
        System.out.println(map1);

        //method2
        Map<String, String> map2 = list.stream().collect(
                Collectors.toMap(
                        student -> student.getId() + "_key",// 第一个方法引用为key,自定义key构成方式
                        Student::getName, // 第二个方法引用为value
                        (key1, key2) -> key1 // 当出现key重复的时候,使用第一此出现的key
                ));
        System.out.println(map2);

        //method3
        Map<String, Student> map3 = list.stream().collect(
                Collectors.toMap(
                        Student::getId,// 第一个方法引用为key,自定义key构成方式
                        student -> student, // 第二个方法引用为value
                        (key1, key2) -> key1 // 当出现key重复的时候,使用第一此出现的key
                ));
        System.out.println(map3);


        //method4
        Map<String, Student> map4 = list.stream().collect(
                Collectors.toMap(
                        Student::getId,// 第一个方法引用为key,自定义key构成方式
                        Function.identity(), // 第二个方法引用为value
                        (key1, key2) -> key1 // 当出现key重复的时候,使用第一此出现的key
                ));
        System.out.println(map4);

        //method5
        Map<String, Teacher> map5 = list.stream().collect(
                Collectors.toMap(
                        Student::getId,// 第一个方法引用为key,自定义key构成方式
                        student -> {
                            return Teacher.builder()
                                    .no(student.getId()).name(student.getName()).build();
                        }, // 第二个方法引用为value
                        (key1, key2) -> key1 // 当出现key重复的时候,使用第一此出现的key
                ));
        System.out.println(map5);

    }
}


@Builder
@Data
class Student {
    String name;
    String id;
}


@Builder
@Data
class Teacher {
    String name;
    String no;
}
