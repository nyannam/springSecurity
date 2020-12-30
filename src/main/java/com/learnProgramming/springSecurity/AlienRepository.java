package com.learnProgramming.springSecurity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepository extends JpaRepository<AlienDetails, Long> {

	 AlienDetails findByUsername(String username);
}
