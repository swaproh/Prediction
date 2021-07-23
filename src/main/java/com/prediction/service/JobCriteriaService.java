package com.prediction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.prediction.dao.CandidateDao;
import com.prediction.dao.IAdminDao;
import com.prediction.dto.JobCriteriaDTO;
import com.prediction.entity.Candidate;
import com.prediction.entity.Job;

@Service
public class JobCriteriaService {
	
	@Autowired
	private CandidateDao candidateDao;
	
	@Autowired
	private IAdminDao iAdminDao;
	
	public ResponseEntity<List<Candidate>> shortlistCandidate(Double min, Double max, List<String> skillReq)
	{
		
		List<Candidate> candidate = candidateDao.findBySkillss(min,max,skillReq);
		ResponseEntity<List<Candidate>> candidateList = new ResponseEntity<List<Candidate>>(candidate,HttpStatus.OK);
		return candidateList;
		
	}

	public ResponseEntity<Candidate> applyJob(Long candidateId, Long jobId) {
		Candidate candidate = candidateDao.findById(candidateId).orElseThrow(RuntimeException::new);
		Job job = iAdminDao.findById(jobId).orElseThrow(RuntimeException::new);
		candidate.getJob().add(job);
		Candidate response = candidateDao.save(candidate);
		return new ResponseEntity<Candidate>(response, HttpStatus.CREATED);
	}

}
