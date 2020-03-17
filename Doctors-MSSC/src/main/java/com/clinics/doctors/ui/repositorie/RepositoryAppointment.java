package com.clinics.doctors.ui.repositorie;

import com.clinics.doctors.ui.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RepositoryAppointment extends JpaRepository<Appointment, Long> {
	Optional<Appointment> findByAppointmentUUID(UUID appointmentUUID);
}
