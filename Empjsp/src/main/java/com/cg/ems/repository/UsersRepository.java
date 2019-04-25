package com.cg.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.bean.Users;

@Repository


public interface UsersRepository extends JpaRepository<Users, Integer> {

	/*Users findByUserId(int UserId);
*/}
 