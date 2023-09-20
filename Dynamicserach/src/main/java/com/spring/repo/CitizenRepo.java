package com.spring.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.model.CitizenPlan;

@Repository
public interface CitizenRepo extends JpaRepository <CitizenPlan,Integer>{
	 @Query("select distinct(planName) from CitizenPlan")
	   public List<String> getUniquePlanNames( );

	   @Query("select distinct(planStatus) from CitizenPlan")
	   public List<String> getUniquePlanStatus( );
	   
	   @Query("select distinct(Gender) from CitizenPlan")
	   public List<String> getGender( );

}
