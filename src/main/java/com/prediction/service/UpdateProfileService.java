package com.prediction.service;

import java.util.List;

import java.util.Optional;

import com.prediction.entity.Candidate;

public interface UpdateProfileService {
	
	
	//For getting single candidate details
	public Optional<Candidate> getCandidate(Long candidateId);
	
	//For getting all candidate details
	public List<Candidate> getAllCandidate();
	
	//For updating candidate details
	public Candidate updateCandidate(Candidate candidate);
	

	
	
	
	

}
