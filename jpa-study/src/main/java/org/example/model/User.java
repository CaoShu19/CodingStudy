package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author : Str2ke
 * @date : 2024/1/7 下午8:22
 * @Desc :
 */
@ToString
@Entity
//@NamedEntityGraph(name = "User.userAddressesById",
//    attributeNodes = {
//            @NamedAttributeNode("userAddressesById")
//    }
//)
@Table(name = "user", schema = "jpa")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;
    @Basic
    @Column(name = "email", nullable = true, length = 200)
    private String email;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id") // @joinColumn 用来定义当前表的外键,此外键关联的是另一张表的主键
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<UserAddress> userAddressesById = new ArrayList<>(16);

}
