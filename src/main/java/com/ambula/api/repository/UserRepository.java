package com.ambula.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ambula.api.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
