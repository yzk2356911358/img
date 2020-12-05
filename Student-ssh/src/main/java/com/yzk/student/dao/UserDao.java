package com.yzk.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzk.student.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
