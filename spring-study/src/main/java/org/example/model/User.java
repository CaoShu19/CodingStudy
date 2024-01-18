package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Str2ke
 * @date : 2024/1/18 下午11:58
 * @Desc :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String name;
    private Integer age;
}
