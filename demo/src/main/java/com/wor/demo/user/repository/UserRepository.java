package com.wor.demo.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.wor.demo.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByNickname(String nickname);
    User findByEmailAndPassword(String email, String password);
}
