package com.prediction.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.prediction.entity.Job;
import com.prediction.exception.MyJobException;


public interface IPostJobService {
 
	 
	public List<Job> getAllJobList();
	
	public Job addJob(Job job) throws MyJobException;

	 

}
