package com.cg.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.ems.bean.Department;

public interface DeptRepository extends JpaRepository<Department,Integer>{

	

}
