package com.clinics.auth.ui.service;

import com.clinics.auth.ui.model.User;
import com.clinics.auth.ui.repositorie.UserRepository;
import com.clinics.auth.security.JwtMaker;
import com.clinics.common.DTO.request.RegisterUserDTO;
import com.clinics.common.DTO.response.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService, JwtMaker {

	final private UserRepository userRepository;
	final private ModelMapper modelMapper;
	final private PasswordEncoder passwordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return this.userRepository.findByEmail(email).orElseThrow();
	}

	public UserResponseDTO saveUser(RegisterUserDTO registerUserDTO) {
		var userAuth = modelMapper.map(registerUserDTO, User.class);
		userAuth.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
		userAuth.setEnable(false);
		userRepository.save(userAuth);
		var userResponse = modelMapper.map(userAuth, UserResponseDTO.class);
		String token = makeJwtToken(userAuth);
		userResponse.setToken(TOKEN_PREFIX + token);
		return userResponse;
	}

	public UserResponseDTO setUserEnable(UUID userUUID) {
		Optional<User> user = userRepository.findByUuid(userUUID);
		if (user.isEmpty() || user.get().isEnable()) {
			throw new NoSuchElementException("User not found");
		}
		var updatedUser = user.get();
		updatedUser.setEnable(true);
        userRepository.save(updatedUser);
        return modelMapper.map(updatedUser, UserResponseDTO.class);
	}
}