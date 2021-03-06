package com.FinalProject.BookStore.data.repository;

import com.FinalProject.BookStore.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
