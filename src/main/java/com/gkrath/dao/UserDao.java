package com.gkrath.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gkrath.entities.User;

import java.util.Date;
import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User findByMobile(String mobile);
}
