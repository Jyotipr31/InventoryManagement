package com.gl.inventorymanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.inventorymanagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	@Query(value = "SELECT * FROM user a WHERE a.username = ?1 AND a.password = ?2", nativeQuery = true)
	public User findUserByUsernameAndPassword(String username ,String password);
	  Optional<User> findByName(String username);
}
