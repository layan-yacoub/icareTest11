package com.example.icare.domain;

import com.example.icare.appointment.Appointment;
import com.example.icare.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "nutritionist")
public class Nutritionist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nutritionist_id;
    @Column(name = "user_id", nullable = false)
    private int user_id;
    @Column(name = "n_first_name", nullable = false)
    private String nFirstName;
    @Column(name = "n_last_name", nullable = false)
    private String nLastName;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "center_name", nullable = false)
    private String centerName;
    @Column(name = "center_license", nullable = false)
    @Lob
    private byte[] centerLicense;
    @Column(name = "nutritionist_license", nullable = false)
    @Lob
    private byte[] nutritionistLicense;
    @Column(name = "experience")
    private int experience;
    @Column(name = "amount")
    private double amount;
    @Column(name = "start_time")
    private Timestamp startTime;
    @Column(name = "end_time")
    private Timestamp endTime;
    @Column(name = "statues")
    private boolean statues = true;

    //@Column(name = "user_id", insertable = false, updatable = false)
    //private Long userId;

    @OneToMany(mappedBy = "nutritionist", cascade = CascadeType.ALL) // One-to-many relationship with appointments
    private List<Appointment> appointments = new ArrayList<>();
    @OneToMany(mappedBy = "nutritionist", cascade = CascadeType.ALL)  // Relationships with Report entity
    private List<Message> messages = new ArrayList<>();

   // @Column(name = "user_id", insertable = false, updatable = false)
   @OneToOne(fetch = FetchType.LAZY)
   @PrimaryKeyJoinColumn
   private User user;



    /*@PostPersist  //ensures that this method is called after the entity is persisted to the database.
    public void generateNutritionistId() {
        nutritionist_id = "N"+ getUser_id() ;
    }*/

   /* @PrePersist
    public void generateId() {
        this.nutritionist_id = "R" + user.getUser_id();
    }*/

    public Nutritionist() { }



}