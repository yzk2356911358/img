package com.yzk.hqbx.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.hqbx.dao.UserDao;
import com.yzk.hqbx.model.User;
import com.yzk.hqbx.service.UserService;

@Service
public class UserServiceimp implements UserService {
	@Autowired
	private UserDao userDao;

	public User getbyid(int id) {
		return userDao.getbyid(id);
	}

	public List<User> findall() {
		return userDao.findall();
	}

	public void del(int id) {
		userDao.del(id);
	}

	public void up(User user) {
		userDao.up(user);
	}

	public void add(User user) {
		userDao.add(user);
	}

}
