package com.example.icare.icare.appointment;

import com.example.icare.icare.domain.Nutritionist;
import com.example.icare.icare.domain.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="appointment")
public class Appointment  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long appointment_id ;
    //the appointment that the patient booked****************
    private Timestamp Appointment_date ;
    // Many-to-one relationship with patient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;
    // Many-to-one relationship with nutritionist
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nutritionist_id")
    private Nutritionist nutritionist;
    // get data from nutritionist
    private double amount= nutritionist.getAmount();
    @Column(nullable = false)
    private Timestamp startTime=nutritionist.getStartTime();
    @Column(nullable = false)
    private Timestamp endTime=nutritionist.getEndTime();



}
