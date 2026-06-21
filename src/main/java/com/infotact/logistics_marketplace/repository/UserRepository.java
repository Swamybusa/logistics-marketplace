package com.infotact.logistics_marketplace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infotact.logistics_marketplace.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	  Optional<User> findByEmail(String email);
}
