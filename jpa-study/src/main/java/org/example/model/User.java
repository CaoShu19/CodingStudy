package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author : Str2ke
 * @date : 2024/1/7 下午8:22
 * @Desc :
 */
@ToString
@Entity
@NamedEntityGraph(name = "User.userAddressesById",
    attributeNodes = {
            @NamedAttributeNode("userAddressesById")
    }
)
@Table(name = "user", schema = "jpa")
@Data
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;
    @Basic
    @Column(name = "email", nullable = true, length = 200)
    private String email;

    @OneToMany(mappedBy = "userByUserId")
    private Collection<UserAddress> userAddressesById = new ArrayList<>(16);

}
