package com.watertracker.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.watertracker.Entities.Users;


public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}

