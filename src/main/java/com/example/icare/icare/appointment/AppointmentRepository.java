package com.example.icare.icare.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findByNutritionistId(Long nutritionistId);
    List<Appointment> findByNutritionistIdAndStartTimeBetween(Timestamp from, Timestamp to);


}
