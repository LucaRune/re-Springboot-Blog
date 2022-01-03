package com.example.myblogproject.repository;

import com.example.myblogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동으로 bean 등록이 된다.
// @Repositoy 생략이 가능
public interface UserRepository extends JpaRepository<User, Integer> {  // User 가 관리하고, User 의 프라이머리 키는 Integer

}
