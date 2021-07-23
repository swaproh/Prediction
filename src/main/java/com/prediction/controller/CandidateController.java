
package com.prediction.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prediction.entity.Candidate;
import com.prediction.entity.Job;
import com.prediction.exception.MyJobException;
import com.prediction.exception.UserNotfoundException;
import com.prediction.service.DeleteProfileService;
import com.prediction.service.ISearchJobService;
import com.prediction.service.RegisterCandidateService;
import com.prediction.service.UpdateProfileService;


@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {
	
	private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);
	
	@Autowired
	private RegisterCandidateService registerCandidateService; 
	
	@Autowired
	private UpdateProfileService updateProfileService;
	
	@Autowired
	private DeleteProfileService deleteProfileService;
	
	@Autowired
	private ISearchJobService searchJobService;
	


	//http://localhost:8080/api/prediction/candidate/add
		@PostMapping(path = "/add")
		public ResponseEntity<Candidate> registerCandidate(@RequestPart("data") Candidate candidate, @RequestPart("resume") MultipartFile file) throws UserNotfoundException
		{
			try {
				logger.info("Trying to add Record  : " + candidate);
				byte[] res = IOUtils.toByteArray(file.getInputStream());
				byte[] img = IOUtils.toByteArray(file.getInputStream());
				candidate.setResume(res);
				candidate.setImage(img);
			} catch (IOException e) {
				System.out.println("Failed to load resume");
				e.printStackTrace();
			}
			Candidate addedCandidate = registerCandidateService.registerCandidate(candidate);
			return new ResponseEntity<Candidate>(addedCandidate, HttpStatus.CREATED);
			
		}

	
	//http://localhost:8080/api/prediction/candidate/view/id
		@GetMapping(path = "/view/{candidateId}", produces = "application/json")
		public ResponseEntity<Candidate> getCandidate(@PathVariable Long candidateId) throws UserNotfoundException
		{
			logger.info("Trying to search Record with Id : " + candidateId);
			try {
			Optional<Candidate> candidate = updateProfileService.getCandidate(candidateId);
			if(candidate.isPresent())
			{
				return new ResponseEntity<Candidate>(candidate.get(),HttpStatus.OK);
			}else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}catch(Exception e) {
				logger.error("Record NOT Found with Id : " + candidateId);
			
				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			}
			
		}
	
	
	
	
	////http://localhost:8080/api/prediction/candidate/
	@GetMapping(path = "/",produces = "application/json")
	public ResponseEntity<List<Candidate>> getAllCandidate() throws UserNotfoundException
	{
		logger.info("Trying to fetch User list ");
		try 
		{
		List<Candidate> candidate = updateProfileService.getAllCandidate();
		if(candidate.isEmpty()) 
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Candidate>>(candidate,HttpStatus.OK);
		}catch(Exception e)
		{
			logger.error("Record NOT found : ");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	//http://localhost:8080/api/prediction/candidate/update/id
		@PutMapping("/update/{candidateId}")
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate, @PathVariable Long candidateId) throws UserNotfoundException 
	{
		logger.info("trying to update user : " + candidate);
		try {
		Optional<Candidate> candidateFound = updateProfileService.getCandidate(candidateId);
		
		if(candidateFound.isPresent())
		{
			updateProfileService.updateCandidate(candidate);
			return ResponseEntity.ok(candidate);
		}else {
			return new ResponseEntity<>(candidate,HttpStatus.NO_CONTENT);
		}
		}catch(Exception e) {
			logger.error("Record NOT updated with Id : " + candidate);
			return new ResponseEntity<Candidate>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	//http://localhost:8080/api/prediction/candidate/delete/id
		@DeleteMapping("/delete/{candidateId}")
		public ResponseEntity<Void> deleteCandidate(@PathVariable Long candidateId) throws UserNotfoundException
		{
			try {
			Optional<Candidate> candidateFound = updateProfileService.getCandidate(candidateId);
			logger.info("Record Deleted with Id : " + candidateId);
			if(candidateFound.isPresent())
			{
				deleteProfileService.deleteCandidate(candidateId);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}else
			{
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}catch(Exception e) {
				logger.error("Record NOT Deleted with Id : " + candidateId);
				return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			}
			
		}
	
	

	
	// http://localhost:8080/api/prediction/candidate/searchjob/skillId
	
	
	@GetMapping(path = "/searchjob/{skillId}", produces = "application/json")
	public  List<Job> getSearchJobList(@PathVariable Long skillId) throws MyJobException{
		logger.info("Trying to fetch skill from joblist ");
		
		List<Job> job = searchJobService.getSearchJobList(skillId);
		
		return job;
		 
	
}

}
