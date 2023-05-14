package com.example.icare.appointment;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class AppointmentRequest {
    private Timestamp startTime;
    private Timestamp endTime;
    private double amount;



}