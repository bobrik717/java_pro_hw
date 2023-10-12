package com.demo.demo1.repository;

import com.demo.demo1.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {}
