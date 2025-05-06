package com.lcwd.user.service.UserService.repositories;

import com.lcwd.user.service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    void deleteById(String userId);


    // if you want to implement any custom method or query
    //write
}
