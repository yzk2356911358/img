package com.yzk.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzk.employee.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
