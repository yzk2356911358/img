package com.yzk.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzk.employee.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
