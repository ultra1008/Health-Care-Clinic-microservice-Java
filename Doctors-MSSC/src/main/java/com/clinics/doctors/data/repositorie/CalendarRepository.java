package com.clinics.doctors.data.repositorie;

import com.clinics.doctors.data.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

//	List<Calendar> getAllByDoctor_Doctoruuid(UUID uuid);
//	Optional<Calendar> getCalendarByCalendaruuid(UUID uuid);
//	void deleteByCalendaruuid(UUID uuid);
	List<Calendar> getCalendarsByDoctor_DoctorUUID(UUID doctorUUID);
	Optional<Calendar> getCalendarByCalendarUUID(UUID calendarUUID);
	void deleteByCalendarUUID(UUID uuid);
}
