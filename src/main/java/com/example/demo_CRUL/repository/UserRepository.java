package com.example.demo_CRUL.repository;

import com.example.demo_CRUL.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
