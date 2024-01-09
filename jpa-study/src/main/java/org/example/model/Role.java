package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Str2ke
 * @date : 2024/1/9 下午10:37
 * @Desc :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role", schema = "jpa")
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id", nullable = false)
    private Integer roleId;
    @Column(name = "role_name", nullable = false, length = 256)
    private String roleName;
    @OneToMany(mappedBy = "role") // mappedBy映射一个另应表User和本表产生的关系属性 user中有一个role,那么就用role
    private Set<User> users = new HashSet<>(16);
}
