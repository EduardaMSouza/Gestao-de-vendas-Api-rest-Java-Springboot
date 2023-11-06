package com.souzamanagement.salesmanagement.repository;

import com.souzamanagement.salesmanagement.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByEmail(String email);
}
