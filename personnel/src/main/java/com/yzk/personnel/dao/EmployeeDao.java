package com.yzk.personnel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzk.personnel.model.Employees;
import com.yzk.personnel.model.User;

public interface EmployeeDao extends JpaRepository<Employees, Integer> {

}
