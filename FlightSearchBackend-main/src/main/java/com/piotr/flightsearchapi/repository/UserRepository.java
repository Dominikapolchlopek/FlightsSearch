package com.piotr.flightsearchapi.repository;

import com.piotr.flightsearchapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE Email = :Email", nativeQuery = true)
    User findByEmail(@Param("Email") String Email);

    @Query(value ="SELECT * FROM users WHERE Email = :Email AND Password_Hash = :PasswordHash", nativeQuery = true)
    User findByEmailAndPassword(@Param("Email") String Email, @Param("PasswordHash") String PasswordHash);
}
