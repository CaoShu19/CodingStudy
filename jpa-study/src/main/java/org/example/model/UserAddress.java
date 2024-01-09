package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author : Str2ke
 * @date : 2024/1/7 下午8:24
 * @Desc :
 */
@Entity
@Table(name = "user_address", schema = "jpa", catalog = "")
@Data
public class UserAddress {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "city", nullable = true, length = 50)
    private String city;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
