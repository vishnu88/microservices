package com.vishnu.userservice.repositories;

import com.vishnu.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,String> {
}
