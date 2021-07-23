/**
 * 
 */
package com.prediction.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prediction.dao.IAdminDao;
import com.prediction.entity.Job;
import com.prediction.entity.Skills;
import com.prediction.exception.MyJobException;

/**
 * @author rojav
 *
 */
@Service
public class PostJobService implements IPostJobService {
	private static final Logger logger = LoggerFactory.getLogger(PostJobService.class);
	
	
	@Autowired
	private IAdminDao adminDao;

	
	@Override
	public List<Job> getAllJobList() {
		List<Job> job = adminDao.findAll();
		return job;
	}
	
	
	 
	@Override
	public Job addJob(Job job) throws MyJobException {
		logger.info("Trying to add Job in postService layer "+ job);
		
		Job addedJob = adminDao.save(job);
		return addedJob;
		 
		
	}

	
	

}
