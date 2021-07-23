
package com.prediction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prediction.entity.Job;

@Repository
 
public interface IAdminDao extends JpaRepository <Job, Long> {

	

	 

	@Query(value ="select j from Job as j join j.requiredSkills s where s.skillId=?1")
	List<Job> findBySkills(@Param("skillId")Long skillId);
	
	 
	 
	 

}
