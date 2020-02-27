package com.clinics.auth.ui.controller;

import com.clinics.auth.ui.service.UserService;
import com.clinics.common.DTO.request.RegisterUserDTO;
import com.clinics.common.DTO.response.UserResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping(value = "/auth")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(
			value = "/users",
			consumes = {
					MediaType.APPLICATION_JSON_VALUE},
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponseDTO> registerUser(@Valid @RequestBody RegisterUserDTO registerUserDTO){
		log.warn(registerUserDTO.getEmail());
		return ResponseEntity.status(201).body(userService.saveUser(registerUserDTO));
	}

	@PutMapping(path = "/users/{userUUID}")
	public ResponseEntity<UserResponseDTO> setUserEnable(@PathVariable UUID userUUID) {
		return ResponseEntity.status(201).body(userService.setUserEnable(userUUID));
	}
}
