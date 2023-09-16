package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.CitizenPlan;

public interface CitizenRepo extends JpaRepository <CitizenPlan,Integer>{

}
