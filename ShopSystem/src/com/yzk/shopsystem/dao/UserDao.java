package com.yzk.shopsystem.dao;

import java.util.List;

import com.yzk.shopsystem.model.User;


public interface UserDao {
	int insert(User user);

	int delete(int id);

	int update(User user);

	List<User> selectByName(String name);

	User selectById(int id);

	List<User> selectAll();
}
