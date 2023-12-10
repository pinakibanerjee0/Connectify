package com.pinaki.connectify.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinaki.connectify.entities.User;

public interface UserRepositoy extends JpaRepository<User,Long>{

}
