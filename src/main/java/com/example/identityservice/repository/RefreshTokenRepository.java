package com.example.identityservice.repository;

import com.example.identityservice.entity.RefreshToken;
import com.example.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUser(User user);
    void deleteByUser(User user);
}