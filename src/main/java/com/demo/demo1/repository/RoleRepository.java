package com.demo.demo1.repository;

import com.demo.demo1.models.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {}
