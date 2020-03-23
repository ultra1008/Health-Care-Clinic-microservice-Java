package com.clinics.doctors.ui.controller;

import com.clinics.common.DTO.request.outer.doctor.EditDoctorDTO;
import com.clinics.common.DTO.request.outer.doctor.RegisterDoctorDTO;
import com.clinics.common.DTO.response.outer.DoctorResponseDTO;
import com.clinics.doctors.ui.service.JPAimpl.DoctorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/doctors")
public class DoctorController {

	final DoctorServiceImpl doctorServiceImpl;
	final RestTemplate restTemplate;

	public DoctorController(DoctorServiceImpl doctorServiceImpl, RestTemplate restTemplate) {
		this.doctorServiceImpl = doctorServiceImpl;
		this.restTemplate = restTemplate;
	}

	@GetMapping
	public ResponseEntity<List<DoctorResponseDTO>> get(){
		return ResponseEntity.ok().body(doctorServiceImpl.getAllDTO());
	}


	@GetMapping(path = "/{doctorUUID}")
	public ResponseEntity<DoctorResponseDTO> getByUUID(
			@PathVariable UUID doctorUUID){
		return ResponseEntity.ok().body(doctorServiceImpl.getDTOByUUID(doctorUUID));
	}

	@PostMapping
	public ResponseEntity<DoctorResponseDTO> add(
			@Valid @RequestBody RegisterDoctorDTO registerDoctorDTO,
			HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(doctorServiceImpl.save(registerDoctorDTO, request));
	}

	@PatchMapping(path = "/{doctorUUID}")
	public ResponseEntity<Void> edit(
			@Valid @RequestBody EditDoctorDTO editDoctorDTO,
			@PathVariable UUID doctorUUID,
			HttpServletRequest request) {
		doctorServiceImpl.edit(editDoctorDTO, doctorUUID, request);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(path = "/{doctorUUID}")
	public ResponseEntity<Void> delete(
			@PathVariable UUID doctorUUID) {
		doctorServiceImpl.delete(doctorUUID);
		return ResponseEntity.ok().build();
	}




	@GetMapping(path = "/test")
	public ResponseEntity<String> getDefault(){
		return ResponseEntity.ok().body("{\"message\":\"Hello world from doctor\"}");
	}

	@GetMapping(path = "/test/{text}")
	public ResponseEntity<String> getTestFromAuth(@PathVariable String text){
		return ResponseEntity.ok().body(restTemplate.getForObject("http://auth/auth/test/" + text, String.class));
	}
}
