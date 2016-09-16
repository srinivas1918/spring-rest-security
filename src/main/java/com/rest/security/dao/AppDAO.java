package com.rest.security.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.security.domain.User;

@Repository
public class AppDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUser(String username){
	Query query=sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
	query.setString("username", username);
	List<User> users=query.list();
	System.out.println(users);
	if (users.size()>0) {
		return users.get(0);
		
	}
		return null;
	}

}
