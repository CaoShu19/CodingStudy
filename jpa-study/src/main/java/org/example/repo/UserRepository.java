package org.example.repo;

import org.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Str2ke
 * @date : 2024/1/7 下午8:59
 * @Desc :
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findByName(@Param("name") String name,
                          Pageable pageable);

    @Query("select u from User u where u.name like %?1")
    Stream<User> testQuery(String name, Pageable pageable);

    @Query("select u from #{#entityName} u where u.name = ?1")
    List<User> testSpEL(String name);

    @Override
    @EntityGraph(value = "User.userAddressesById")
    List<User> findAll();
}
