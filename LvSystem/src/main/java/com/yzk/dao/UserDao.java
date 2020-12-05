package com.yzk.dao;

import java.util.List;

import com.yzk.model.User;

public interface UserDao {
	List<User> findall();

	User getbyid(int id);

	void del(int id);

	void add(User user);

	void up(User user);

}
