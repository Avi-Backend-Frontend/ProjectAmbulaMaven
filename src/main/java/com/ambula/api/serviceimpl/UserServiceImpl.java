package com.ambula.api.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ambula.api.entity.User;
import com.ambula.api.repository.UserRepository;
import com.ambula.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUserTable() {
		
	}

	@Override
	public void updateUser(User user) {
		
	}

	@Override
	public List<User> getNearestUsers(int N) {
		
		return null;
	}
	

}
