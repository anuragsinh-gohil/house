package com.house.house.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.house.house.entity.House;

@Repository
public interface HouseRepo extends JpaRepository<House, Integer> {
} 
