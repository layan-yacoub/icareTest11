package com.example.icare.icare.service;

import com.example.icare.icare.domain.Patient;
import com.example.icare.icare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long patiant_id) {
        return patientRepository.findById(patiant_id).orElse(null);
    }

}
