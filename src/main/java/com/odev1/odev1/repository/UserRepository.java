package com.odev1.odev1.repository;

import com.odev1.odev1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
