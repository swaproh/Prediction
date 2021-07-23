
package com.prediction.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"candidate"})
@Entity
@Table(name = "job")
public class Job implements Serializable{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private Long jobId;
	
	
	@Column(name = "job_title")
	private String jobTitle;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "job_location")
	private String jobLocation;
	
	@Column(name = "salary")
	private Float salary;
	
	
	
	@Column(name = "required_expirence")
	private Double requiredExpirence;
	
	@Column(name = "vacancy")
	private Long vacancy;
	
	@Column(name = "company_name")
	private String companyName;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "skills_job",
				joinColumns = @JoinColumn(name = "job_id"),
				inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skills> requiredSkills = new ArrayList<>();

	
	@ManyToMany(mappedBy = "job")
    private List<Candidate> candidate = new ArrayList<Candidate>();


	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getJobId() {
		return jobId;
	}


	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getJobLocation() {
		return jobLocation;
	}


	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}


	public Float getSalary() {
		return salary;
	}


	public void setSalary(Float salary) {
		this.salary = salary;
	}


	public Double getRequiredExpirence() {
		return requiredExpirence;
	}


	public void setRequiredExpirence(Double requiredExpirence) {
		this.requiredExpirence = requiredExpirence;
	}


	public Long getVacancy() {
		return vacancy;
	}


	public void setVacancy(Long vacancy) {
		this.vacancy = vacancy;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}




	public List<Skills> getRequiredSkills() {
		return requiredSkills;
	}


	public void setRequiredSkills(List<Skills> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}


	public List<Candidate> getCandidate() {
		return candidate;
	}


	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}
	
	
}
