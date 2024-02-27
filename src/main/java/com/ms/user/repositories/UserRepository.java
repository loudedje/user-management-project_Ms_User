package com.ms.user.repositories;

import com.ms.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findById(Long id);

    Optional<UserModel> findByEmail(String email);
}
