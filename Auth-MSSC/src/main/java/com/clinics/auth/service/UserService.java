package com.clinics.auth.service;

import com.clinics.auth.model.UserDAO;
import com.clinics.auth.repositorie.UserRepository;
import com.clinics.auth.security.JwtMaker;
import com.clinics.common.DTO.request.RegisterUserDTO;
import com.clinics.common.DTO.response.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService, JwtMaker {

	private UserDAO userDAO;
	private ModelMapper modelMapper;
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		this.userDAO = this.userRepository.findByEmail(email).orElseThrow();
		return this.userDAO;
	}

	public UserResponseDTO saveUser(RegisterUserDTO registerUserDTO) {
		var userAuth = modelMapper.map(registerUserDTO, UserDAO.class);
		userAuth.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
		userRepository.save(userAuth);
		var userResponse = modelMapper.map(userAuth, UserResponseDTO.class);
		String token = makeJwtToken(userAuth);
		userResponse.setToken(TOKEN_PREFIX + token);
		return userResponse;

	}

	public boolean existsUserDAOByEmail(String email) {
		return userRepository.existsUserDAOByEmail(email);
	}
}