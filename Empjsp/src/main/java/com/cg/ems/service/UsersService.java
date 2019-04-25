package com.cg.ems.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ems.bean.Users;
import com.cg.ems.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	UsersRepository usersRepository;
	

	@Transactional
	public	Users recordsAdd(Users users) {
		
		Users ad = usersRepository.save(users);
		return ad;
	}
	@Transactional
	public Users retrive(int UserId) {

		Users ad = usersRepository.findOne(UserId);
		return ad;
	}

}

