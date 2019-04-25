package com.cg.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.bean.GradeMaster;

@Repository
public interface GradeRepository extends JpaRepository<GradeMaster,String> {

}
