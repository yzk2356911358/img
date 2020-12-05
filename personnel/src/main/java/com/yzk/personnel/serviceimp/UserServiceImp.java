package com.yzk.personnel.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzk.personnel.dao.UserDao;
import com.yzk.personnel.model.User;
import com.yzk.personnel.service.UserService;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserDao userdao;

	@Override
	public void add(User user) {
		userdao.save(user);
	}

	@Override
	public void del(int id) {
		userdao.delete(userdao.getOne(id));
	}

	@Override
	public void up(User user) {
		User temp = userdao.getOne(user.getId());
		temp = user;
		userdao.save(temp);
	}

	@Override
	public List<User> findall() {
		return userdao.findAll();
	}

}
