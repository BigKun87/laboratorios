package com.lp.repository;

import com.lp.entity.UserEntity;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, BigInteger>{

	@Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
	public UserEntity findByEmail(String email);
}
