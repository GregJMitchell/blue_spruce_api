package com.spruce.Blue.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    List<User> findAll();
//    @Query("SELECT u.id, u.name, u.email FROM USERS u")
//    List<User> getUsers();
}
