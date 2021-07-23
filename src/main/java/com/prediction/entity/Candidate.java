
package com.prediction.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


//@JsonIgnoreProperties(value= {"skills"})
@Entity
@Table(name = "candidate")
public class Candidate {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidate_id")
	private Long candidateId;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "contact_no")
	private Long contactNo;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "dob")
	private LocalDate dob;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "postal_code")
	private Long postalCode;
	
	@Column(name = "total_experience")
	private Double totalExperience;	
	
	@Column(name = "resume")
	private byte[] resume;
	
	@Column(name = "image")
	private byte[] image;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "skills_candidate",
				joinColumns = @JoinColumn(name = "candidate_id"),
				inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private List<Skills> candSkills = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "job_candidate",
				joinColumns = @JoinColumn(name = "candidate_id"),
				inverseJoinColumns = @JoinColumn(name = "job_id"))
	private List<Job> job = new ArrayList<>();

	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public List<Job> getJob() {
		return job;
	}


	public void setJob(List<Job> job) {
		this.job = job;
	}


	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Long postalCode) {
		this.postalCode = postalCode;
	}

	public Double getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(Double totalExperience) {
		this.totalExperience = totalExperience;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}


	public List<Skills> getCandSkills() {
		return candSkills;
	}


	public void setCandSkills(List<Skills> candSkills) {
		this.candSkills = candSkills;
	}	
	
}
