package com.clinics.doctors.data.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;


@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder(toBuilder = true)
@ToString(exclude = {"calendars", "specializations"})
@DynamicInsert
@DynamicUpdate
//@Builder(toBuilder = true, builderMethodName = "hiddenBuilder")
@Entity(name = "doctor")
public class Doctor {

//	public static DoctorBuilder builder(UUID uuid) {
//		return hiddenBuilder().uuid(uuid);
//	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;

	@Column(updatable = false,
			nullable = false,
			unique = true)
	private UUID doctorUUID;

	@NotBlank(message = "fistName is mandatory")
	@Size(min = 2, max = 100, message = "firstName length out of range")
	private String firstName;

	@NotBlank(message = "lastName is mandatory")
	@Size(min = 3, max = 100, message = "lastName length out of range")
	private String lastName;

//	private int age;

	@URL
	@Column(unique = true)
	@Size(min = 3, max = 500, message = "photoUrl length out of range ")
	private String photoUrl;

	@Column(unique = true, nullable = false)
	private String licence;

	@JsonIdentityReference
	@ManyToMany(targetEntity = Specialization.class)
	@JoinTable(
			name = "doctor_specialization",
			joinColumns = {@JoinColumn(name = "doctor_id")},
			inverseJoinColumns = {@JoinColumn(name = "spacialization_id")})
	private Collection<Specialization> specializations;

	@OneToMany(
			targetEntity= Calendar.class,
			mappedBy="doctor",
			cascade={CascadeType.REMOVE},
			fetch = FetchType.LAZY,
			orphanRemoval=true)
	private Collection<Calendar> calendars;


//	@JsonIgnore
	@ElementCollection
	private Collection<UUID> patientsUUID;

	@ElementCollection
	private Collection<UUID> medicalUnitsUUID;
}

