package org.example.repo;

import org.example.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Str2ke
 * @date : 2024/1/7 下午8:59
 * @Desc :
 */
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
}
