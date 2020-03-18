package com.clinics.doctors.data.repositorie;

import com.clinics.doctors.data.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	Optional<Doctor> findByDoctorUUID(UUID uuid);
	boolean existsByDoctorUUID(UUID uuid);
	void deleteByDoctorUUID(UUID uuid);
	List<Doctor> findAllByMedicalUnitsUUID(UUID medicalUnitesUUID);
}
