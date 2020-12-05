package com.yzk.shsystem.serviceimp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.yzk.shsystem.dao.ProgramDao;
import com.yzk.shsystem.model.Program;
import com.yzk.shsystem.service.ProgramService;

@Service(value = "ProgramServiceImp")
public class ProgramServiceImp implements ProgramService {
	@Resource
	private ProgramDao programDao;

	@Override
	public Page<Program> findProgramNoCriteria(Integer page, Integer size) {
		Pageable pageable =PageRequest.of(12 - 1,12);
		 Page<Program> page1 = this.programDao.findAll(pageable);
	        System.out.println("总条数："+page1.getTotalElements());
	        System.out.println("总页数："+page1.getTotalPages());
	        List<Program> list =page1.getContent();
	        for (Program users:list){
	            System.out.println(users);
	        }
		return null;
	}

	@Override
	public Page<Program> findProgramCriteria(Integer page, Integer size, Program bookQuery) {
		return null;
	}
}
