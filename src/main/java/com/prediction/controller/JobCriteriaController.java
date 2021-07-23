package com.prediction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prediction.dto.JobCriteriaDTO;
import com.prediction.entity.Candidate;
import com.prediction.service.JobCriteriaService;

@RestController
@RequestMapping(value="/job")
public class JobCriteriaController {
	
	@Autowired
	private JobCriteriaService jobCriteriaService;
	
	@GetMapping(value="/criteria")
	public ResponseEntity<List<Candidate>> shortlistCandidate(@RequestHeader(name = "minExp") Double min,@RequestHeader(name = "maxExp") Double max,@RequestHeader(name="skillReq") List<String> skillReq)
	{
		
		
		return jobCriteriaService.shortlistCandidate(min,max,skillReq);
		
	}
	
	
	@PostMapping(value="/apply/{cId}/{jId}")
	public ResponseEntity<Candidate> applyJob(@PathVariable("cId") Long candidateId, @PathVariable("jId") Long jobId){
		return jobCriteriaService.applyJob(candidateId, jobId);
	}

}
