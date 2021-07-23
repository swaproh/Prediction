package com.prediction.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"candidate", "job"})
@Entity
@Table(name = "skills")
public class Skills implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
    private Long skillId;
   
    @Column(name = "skill_name")
    private String skillName;
    
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH},mappedBy = "requiredSkills")
    private List<Job> job= new ArrayList<Job>();
    
    @ManyToMany(mappedBy = "candSkills")
    private List<Candidate> candidate = new ArrayList<Candidate>();

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}

	public List<Candidate> getCandidate() {
		return candidate;
	}

	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}

    

   
}
