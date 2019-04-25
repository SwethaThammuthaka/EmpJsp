package com.cg.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.bean.GradeMaster;
import com.cg.ems.repository.GradeRepository;

@Service
public class GradeService {
	@Autowired
	private GradeRepository gradrepo;

	public GradeMaster addgrade(GradeMaster grademaster) {
		// TODO Auto-generated method stu
		return gradrepo.save(grademaster);

	}

	public List<GradeMaster> getallgrades() {
		return gradrepo.findAll();
	}
	
	

}

