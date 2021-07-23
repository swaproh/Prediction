package com.prediction.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//@Entity
//@Table(name = "shortlisted_candidate")
public class JobCriteriaDTO {
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "shortlist_candidate_id")
//	private Long shortlistCandidateId;
	
	private List<String> skills = new ArrayList<>();
	
	private Double requiredExp;

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public Double getRequiredExp() {
		return requiredExp;
	}

	public void setRequiredExp(Double requiredExp) {
		this.requiredExp = requiredExp;
	}
	
	

}
