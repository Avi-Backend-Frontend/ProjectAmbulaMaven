package com.ambula.api.service;

import java.util.List;

import com.ambula.api.entity.User;

public interface UserService {

	public User createUserTable(User user);

	public void updateUser(User user);

	public List<User> getNearestUsers(int N);

}
