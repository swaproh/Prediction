/**
 * 
 */
package com.prediction.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prediction.dao.CandidateDao;
import com.prediction.dao.IAdminDao;
import com.prediction.entity.Job;
import com.prediction.exception.MyJobException;

/**
 * @author rojav
 *
 */
@Service
public class SearchJobService implements ISearchJobService{

	private static final Logger logger = LoggerFactory.getLogger(PostJobService.class);
	
	@Autowired
	private IAdminDao adminDao;
	
 
	 
	@Autowired
	private CandidateDao candidateDao;

	 
	
	@Override
	public List<Job> getSearchJobList(Long skillId)throws MyJobException {
		
		List<Job> job=adminDao.findBySkills(skillId);
		// TODO Auto-generated method stub
		logger.info("Trying to search skill in job "+ skillId);
		return  job;
	}

	 

	
	 
	

	
	
	
}
