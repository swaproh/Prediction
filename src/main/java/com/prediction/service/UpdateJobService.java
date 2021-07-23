/**
 * 
 */
package com.prediction.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediction.dao.IAdminDao;
import com.prediction.entity.Job;
import com.prediction.exception.MyJobException;

/**
 * @author rojav
 *
 */
@Service
public class UpdateJobService implements IUpdateJobService {
	
	private static final Logger logger = LoggerFactory.getLogger(UpdateJobService.class);
	
	@Autowired
	private IAdminDao adminDao;

	@Override
	public Optional<Job> getJobById(Long jobId) throws MyJobException {
		// TODO Auto-generated method stub
		logger.info("Trying to fetch Jobs in update service layer ");
		return adminDao.findById(jobId);
	}

	@Override
	@Transactional
	public Job updateJob(Job job) throws MyJobException {
		// TODO Auto-generated method stub
		logger.info("Trying to update Job in update service layer ");
		
		Long jobId = job.getJobId();
		Optional<Job> jobFound = getJobById(jobId);
		Job updatedJob = null;
		if (jobFound.isPresent())
			updatedJob = adminDao.save(job);
		return updatedJob;
	}

	@Override
	public void deleteJob(Long jobId) throws MyJobException {
		// TODO Auto-generated method stub
		logger.info("Trying to delete Job in update service layer ");
		adminDao.deleteById(jobId);
	}
	
	 
}
