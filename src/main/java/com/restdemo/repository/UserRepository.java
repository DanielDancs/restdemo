package com.restdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.restdemo.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
