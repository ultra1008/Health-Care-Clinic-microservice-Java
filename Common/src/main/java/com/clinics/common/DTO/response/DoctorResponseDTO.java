package com.clinics.common.DTO.response;

import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(toBuilder = true)
public class DoctorResponseDTO {
	private UUID doctor_uuid;
	private String firstName;
	private String lastName;
	private String photoUrl;
	private String licence;

	private Collection<Object> calendars;
	private Collection<Object> specializations;

//	private Collection<UUID> patientsUUIDs; todo get ALL cannot show patients ? however there will be only uuid so ... ?
	private Collection<UUID> medicalUnits;

}
