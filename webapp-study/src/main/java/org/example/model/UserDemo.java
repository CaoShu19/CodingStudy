package org.example.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author : Str2ke
 * @date : 2024/2/4 上午1:30
 * @Desc :
 */
@Data
public class UserDemo {
    @JsonProperty("user_name1") // 这将所有user_name1为属性的值都映射到user_name1上,可反序列化
    private String userName;
    @JsonAlias({"nick_name1","nick_name2"})
    // 将其中出现的属性值映射到nickName上,但是返回列化会和原始json不同
    private String nickName;

    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT-8")
    private Date lastLoginTime;
}
