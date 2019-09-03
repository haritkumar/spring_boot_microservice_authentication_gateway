package com.gateway.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gateway.entity.JwtToken;


@Repository
public interface JwtTokenRepository extends CrudRepository<JwtToken,Long> {
	Long deleteByToken(String token);
	JwtToken findByToken(String token);
}
