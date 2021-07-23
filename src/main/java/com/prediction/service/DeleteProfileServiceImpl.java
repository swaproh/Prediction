package com.prediction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediction.dao.CandidateDao;


@Service
public class DeleteProfileServiceImpl implements DeleteProfileService{
	
	@Autowired
	private CandidateDao candidateDao;
	
	//for deleting single candidate
		@Override
		public void deleteCandidate(Long candidateId) {
			
			candidateDao.deleteById(candidateId);;
		}
		
		
		


}
