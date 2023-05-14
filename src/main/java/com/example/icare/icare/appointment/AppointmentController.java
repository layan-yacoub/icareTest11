package com.example.icare.appointment;

import com.example.icare.domain.Payment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@RestController
@RequestMapping(path = "api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;


    //every nutritionist create appointments
    @PostMapping("/createAppointments/{nutritionist_id}")
    public String createAppointment(@RequestBody AppointmentRequest appointmentRequest, @PathVariable Long nutritionist_id) {
        Timestamp startTime = appointmentRequest.getStartTime();
        Timestamp endTime = appointmentRequest.getEndTime();
        double amount = appointmentRequest.getAmount();

        Appointment appointment = new Appointment();
        appointment.setStartTime(startTime);
        appointment.setEndTime(endTime);
        appointment.setAmount(amount);

        assert appointmentService != null;
        appointmentService.save(appointment);

        return "Appointment created successfully!";
    }
    //to see the appointments for specific nutritionist
    @GetMapping("/getAppointments/{nutritionist_id}")
    public List<Appointment> getAppointments(@PathVariable Long nutritionist_id) {
        //  Return appointments for a specific nutritionist based on the nutritionistId
        assert appointmentService != null;
        return appointmentService.findByNutritionistId(nutritionist_id);
    }
    // the available appointments for specific nutritionist in specific date
    @GetMapping("/appointments/{nutritionist_id}/available")
    public List<Appointment> getAvailableAppointments(
    @PathVariable Long nutritionist_id,
    @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Timestamp from,
    @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Timestamp to) {
        // Return a list of available appointments within the specified time range for a specific nutritionist
        assert appointmentService != null;
        return appointmentService.findByNutritionistIdAndStartTimeBetween(from, to);
    }
// to book an appointment
@PostMapping("/appointments/book")
public String bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
    // Get the necessary details from the appointmentRequest
    Timestamp startTime = appointmentRequest.getStartTime();
    Timestamp endTime = appointmentRequest.getEndTime();
    double amount = appointmentRequest.getAmount();

    // Perform any necessary validation or business logic for booking the appointment
    boolean paymentSuccess = performPaymentLogic(amount);

    if (paymentSuccess) {
        // Create an instance of the Appointment entity and set its properties
        Appointment appointment = new Appointment();
        appointment.setStartTime(startTime);
        appointment.setEndTime(endTime);
        appointment.setAmount(amount);
        // Save the appointment in the database using the appointmentRepository
        assert appointmentService != null;
        appointmentService.save(appointment);

        return "Appointment booked and confirmed successfully!";
    } else {
        return "Failed to book appointment due to payment failure.";
    }
}

    private boolean performPaymentLogic(double amount) {
        Payment payment= new Payment();
        payment.setPayment_amount(amount);
        payment.setPayment_date(LocalDate.now());
        return true;
    }

    public void deleteAppointment(Appointment appointment) {
        // Delete the appointment from the database using the appointmentRepository
        assert appointmentService != null;
        appointmentService.delete(appointment);
    }


}

