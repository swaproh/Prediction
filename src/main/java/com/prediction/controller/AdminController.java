/**
 * 
 */
package com.prediction.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.prediction.entity.Job;
import com.prediction.exception.MyJobException;
import com.prediction.exception.UserNotfoundException;
import com.prediction.service.IPostJobService;
import com.prediction.service.IUpdateJobService;

/**
 * @author rojav
 *
 */
 
@RestController
@RequestMapping(value="/jobs")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private IPostJobService postJobService;
	
	@Autowired
	private IUpdateJobService updateJobService;
	

	
	
	
	// http://localhost:8070/api/prediction/jobs/
	
	@GetMapping(path = "/",produces = "application/json")
	public ResponseEntity<List<Job>> getAllJobList() throws UserNotfoundException
	{
		logger.info("Trying to fetch User list ");
		try 
		{
		List<Job> job = postJobService.getAllJobList();
		if(job.isEmpty()) 
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Job>>(job,HttpStatus.OK);
		}catch(Exception e)
		{
			logger.error("Record NOT found : ");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	// http://localhost:8055/api/prediction/jobs/add
	
	 
		
	@PostMapping(path = "/add")
	public ResponseEntity<Job> addJob(@RequestBody Job job) throws UserNotfoundException {
		try {
			logger.info("Trying to add Record  : " + job);
			
			Job addedJob = postJobService.addJob(job);
			
			return new ResponseEntity<Job>(addedJob, HttpStatus.CREATED);//201
		} catch (Exception e) {
			logger.error("Record NOT Added  : " + job);
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			
		}
	}
		
		
		// http://localhost:8055/api/prediction/jobs/1
		
		
		@GetMapping(path = "/{jobId}", produces = "application/json")
		 
		public ResponseEntity<Job> getJobById(@PathVariable Long jobId) throws MyJobException{
			Optional<Job> job=null;
			logger.info("Trying to search Record with Id : " + jobId);
			try {
				
				job=updateJobService.getJobById(jobId);
			
			if (job.isPresent()) {
				return new ResponseEntity<>(job.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			 
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
		}
		
		
		
		// http://localhost:8055/api/prediction/jobs/1	
		
		
		@DeleteMapping("/{jobId}")
		public ResponseEntity<String> deleteJob(@PathVariable Long jobId) throws UserNotfoundException {
			 
			try {
				updateJobService.deleteJob(jobId);
				Optional<Job> delJob = updateJobService.getJobById(jobId);
				return new ResponseEntity<>("Record Deleted...with id : "+jobId,HttpStatus.OK);
				
			} catch (Exception e) {
				 
				return new ResponseEntity<>("Record not found with id : "+jobId,HttpStatus.EXPECTATION_FAILED);
			}
		}
		
	
		// http://localhost:8055/api/prediction/1	
		
		@PutMapping("/{jobId}")
		public ResponseEntity<Object> updateUser(@RequestBody Job job, @PathVariable Long jobId)
				throws UserNotfoundException {
			 
			try {
				Optional<Job> jobFound = updateJobService.getJobById(jobId);

				if (jobFound.isPresent()) {
					updateJobService.updateJob(job);
					
					System.out.println("Record Updated : " + job);
					return ResponseEntity.ok(job);
				} else {
					return new ResponseEntity<>("Record NOT updated with Id : " + job,HttpStatus.NO_CONTENT);
				}
			} catch (Exception e) {
				 
				return new ResponseEntity<>("Record NOT updated with Id : " + job, HttpStatus.EXPECTATION_FAILED);
			}

		}
		
		 
		
		
		 
				 
		
		 
		 
}
