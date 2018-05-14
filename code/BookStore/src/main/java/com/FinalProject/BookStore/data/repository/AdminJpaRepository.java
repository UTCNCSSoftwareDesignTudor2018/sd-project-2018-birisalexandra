package com.FinalProject.BookStore.data.repository;

import com.FinalProject.BookStore.data.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminJpaRepository extends JpaRepository<Admin, Integer> {
}
