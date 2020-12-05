package com.yzk.hqbx.dao;

import java.util.List;
import com.yzk.hqbx.model.User;

public interface UserDao {
	User getbyid(int id);

	List<User> findall();

	void del(int id);

	void up(User user);

	void add(User user);
}
