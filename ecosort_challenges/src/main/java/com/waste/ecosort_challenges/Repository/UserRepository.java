package com.waste.ecosort_challenges.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.waste.ecosort_challenges.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
