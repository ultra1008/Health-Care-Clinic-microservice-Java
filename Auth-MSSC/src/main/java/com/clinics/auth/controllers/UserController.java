package com.clinics.auth.controllers;

import com.clinics.auth.services.UserService;
import com.clinics.common.DTO.request.RegisterUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping(value = "/auth")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/test")
	public ResponseEntity<String> getTest(){
		return ResponseEntity.ok().body("Hello world from AUTH");
	}

	@PostMapping(value = "/users")
	public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserDTO registerUserDTO){
		log.warn(registerUserDTO.getEmail());
		log.warn(registerUserDTO.getPassword());
		log.warn(registerUserDTO.getRole());
		return ResponseEntity.ok().body("Hello world from AUTH");
	}
}
