package com.qzce.withteam.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPidAndPassword(String pid, String password);

    Optional<User> findByEmail(String email); // first sign up or not.

}
