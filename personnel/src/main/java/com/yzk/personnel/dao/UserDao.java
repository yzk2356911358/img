package com.yzk.personnel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzk.personnel.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
