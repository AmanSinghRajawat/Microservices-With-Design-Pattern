package com.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
