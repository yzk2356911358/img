package com.yzk.personnel.service;

import java.util.List;

import com.yzk.personnel.model.User;

public interface UserService {
	void add(User user);

	void del(int id);

	void up(User user);

	List<User> findall();
}
