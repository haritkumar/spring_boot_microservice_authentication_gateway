package com.gateway.api;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.dto.AppUserDto;
import com.gateway.dto.BaseApiResponse;
import com.gateway.entity.Role;
import com.gateway.entity.User;
import com.gateway.repo.RoleRepository;
import com.gateway.repo.UserRepository;

@RequestMapping("/auth")
@RestController
public class AuthApi {

	Logger logger = LoggerFactory.getLogger(AuthApi.class);
	 
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<BaseApiResponse> register(AppUserDto appUserDto){
		logger.info("Registering user : {}",appUserDto.toString());
		try {
			Role role = roleRepository.findByRole("ROLE_USER");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			User u = new User();
			u.setActive(1);
			u.setEmail(appUserDto.getEmail());
			u.setEnabled(true);
			u.setExpired(false);
			u.setLastName(appUserDto.getLname());
			u.setLoacked(false);
			u.setName(appUserDto.getFname());
			u.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
			u.setRole(roles);
			userRepository.save(u);
			BaseApiResponse baseApiResponse = new BaseApiResponse();
			baseApiResponse.setMessage("User has been registered successfully");
			baseApiResponse.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			BaseApiResponse baseApiResponse = new BaseApiResponse();
			baseApiResponse.setMessage("Internal Server Error");
			baseApiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<BaseApiResponse>(baseApiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
