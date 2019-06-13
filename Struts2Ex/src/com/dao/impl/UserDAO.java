package com.dao.impl;

import java.util.List;

import common.model.User;

public interface UserDAO {

	public int saveOrUpdateUser(User user);
	public List<User> listUser();
	public User listUserById(Integer userId);
	public int deleteUser(Integer userId);
}
