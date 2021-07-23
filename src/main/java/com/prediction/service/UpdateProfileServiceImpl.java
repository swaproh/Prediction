package com.prediction.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediction.dao.CandidateDao;
import com.prediction.entity.Candidate;


@Service
public class UpdateProfileServiceImpl implements UpdateProfileService{
	
	
	@Autowired
	private CandidateDao candidatedDaoI;

	
	//for getting single candidate details
	@Override
	public Optional<Candidate> getCandidate(Long candidateId) {
		Optional<Candidate> candidate = candidatedDaoI.findById(candidateId);
		//candidate.get().getSkills();
		return candidate;
		
	}
	
	
	//for getting all candidate details
	@Override
	public List<Candidate> getAllCandidate() {
		List<Candidate> candidates = candidatedDaoI.findAll();
		return candidates;
	}

	
	
	//for updating the candidate details
	@Override
	public Candidate updateCandidate(Candidate candidate) {
		Long candidateId = candidate.getCandidateId();
		Optional<Candidate> candidateFound = getCandidate(candidateId);
		Candidate updatedCandidate = null;
		if(candidateFound.isPresent())
			updatedCandidate = candidatedDaoI.save(candidate);
		return updatedCandidate;
	}



	
	
	

}
