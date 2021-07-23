/**
 * 
 */
package com.prediction.service;


import java.util.List;



import com.prediction.entity.Job;

import com.prediction.exception.MyJobException;

/**
 * @author rojav
 *
 */

public interface ISearchJobService  {
	
	public List<Job> getSearchJobList(Long skillId)throws MyJobException;
	
}
