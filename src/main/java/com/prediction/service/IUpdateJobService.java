/**
 * 
 */
package com.prediction.service;

import java.util.Optional;

import com.prediction.entity.Job;
import com.prediction.exception.MyJobException;

/**
 * @author rojav
 *
 */
public interface IUpdateJobService {
	
	public Optional<Job> getJobById(Long jobId) throws MyJobException;
	
	public Job updateJob(Job job)throws MyJobException;
	
	public void deleteJob(Long jobId)throws MyJobException;

}
