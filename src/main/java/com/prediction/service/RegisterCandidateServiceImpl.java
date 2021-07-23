package com.prediction.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediction.dao.CandidateDao;
import com.prediction.entity.Candidate;


@Service
public class RegisterCandidateServiceImpl implements RegisterCandidateService{
	
	@Autowired
	private CandidateDao candidatedDaoI;


	@Transactional
	public Candidate registerCandidate(Candidate candidate) {
		
		Candidate addedCandidate = candidatedDaoI.save(candidate);
		return addedCandidate;
	}

}
