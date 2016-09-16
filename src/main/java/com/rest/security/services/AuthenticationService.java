package com.rest.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.security.domain.LoggedUser;
import com.rest.security.domain.User;

/**
 * 
 * @author Srinivas Nalla
 *
 */
@Service
@Transactional
public class AuthenticationService implements UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired 
	private AppService appService;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user=appService.getUser(username);
		if(user==null){
			throw new UsernameNotFoundException("User doesn`t exist");
		}
		logger.info("user name "+user);
		//Fetching User roles form DB.
		String userRoles=user.getUser_Role();
		List<String> dbRoles=new ArrayList<String>();
		dbRoles.add(userRoles);
		
		logger.debug("Roles of :"+username+" is "+dbRoles);
		
		// pass user object and roles to LoggedUser
		LoggedUser loggedUser=new LoggedUser(user, dbRoles);
		return loggedUser;
	}

}
