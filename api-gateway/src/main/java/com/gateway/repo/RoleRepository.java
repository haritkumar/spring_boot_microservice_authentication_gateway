package com.gateway.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gateway.entity.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
	
	Role findByRole(String role);
}
