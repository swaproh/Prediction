package com.prediction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prediction.entity.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Long>{

	@Query("select c from Candidate c left join c.candSkills s where c.totalExperience >= ?1 and c.totalExperience <= ?2 and s.skillName in (?3)")
	List<Candidate> findBySkillss(Double min, Double max, List<String> skillReq);

}
