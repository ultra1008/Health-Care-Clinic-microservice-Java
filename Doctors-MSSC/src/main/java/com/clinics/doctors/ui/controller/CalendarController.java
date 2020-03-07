package com.clinics.doctors.ui.controller;

import com.clinics.common.DTO.request.outer.AddCalendarDTO;
import com.clinics.common.DTO.response.outer.CalendarResponseDTO;
import com.clinics.doctors.ui.model.Calendar;
import com.clinics.doctors.ui.model.Doctor;
import com.clinics.doctors.ui.service.CalendarService;
import com.clinics.doctors.ui.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequestMapping(value = "/doctors/{doctorUUID}/calendars")
public class CalendarController {

	final private CalendarService calendarService;

	public CalendarController(
			CalendarService calendarService){
		this.calendarService = calendarService;
	}

	@GetMapping
	public ResponseEntity<List<Calendar>> getDoctorCalendars(@PathVariable UUID doctorUUID){
		return ResponseEntity.ok().body(calendarService.getDoctorCalendars(doctorUUID));
	}

	@PostMapping
	public ResponseEntity<CalendarResponseDTO> addCalendar(
			@Valid @RequestBody AddCalendarDTO addCalendarDTO,
			@PathVariable UUID doctorUUID) {
		return ResponseEntity.status(201).body(calendarService.save(addCalendarDTO, doctorUUID));
	}
}
