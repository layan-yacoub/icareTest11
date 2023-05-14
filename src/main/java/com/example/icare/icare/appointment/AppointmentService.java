package com.example.icare.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }
    public Appointment addAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }
    public void save(Appointment appointment) { appointmentRepository.save(appointment);
    }
   //for the admin
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
    public List<Appointment> findByNutritionistId(Long nutritionist_id) {
        return appointmentRepository.findByNutritionistId(nutritionist_id);
    }
    public List<Appointment> findByNutritionistIdAndStartTimeBetween(Timestamp from, Timestamp to) {
        return appointmentRepository.findByNutritionistIdAndStartTimeBetween(from, to);
    }

    public void deleteAppointment(Appointment appointment) {
            // Delete the appointment from the database
            appointmentRepository.delete(appointment);
        }

    public void delete(Appointment appointment) {
        appointmentRepository.delete(appointment);
    }
}


