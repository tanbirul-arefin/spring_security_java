package com.real.spring_security_demo.repository;

import com.real.spring_security_demo.model.user;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userrepository extends JpaRepository<user, Integer> {
    user findByUsername(String username);
}