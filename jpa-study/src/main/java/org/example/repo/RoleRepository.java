package org.example.repo;

import org.example.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Str2ke
 * @date : 2024/1/9 下午11:14
 * @Desc :
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
