package com.rest.security.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.security.dao.AppDAO;
import com.rest.security.domain.User;

@Service
public class AppService {
	private static final Logger logger = LoggerFactory.getLogger(AppService.class);
	
	
	@Autowired
	private AppDAO appDAO;
	
	@Transactional(readOnly=true)
	public User getUser(String username){
	return appDAO.getUser(username);	
	}
	
	
}
