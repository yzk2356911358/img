package com.yzk.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzk.student.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

}
