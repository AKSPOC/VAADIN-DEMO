package com.example.demo.dao;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointment_data")
@Builder
public class AppointmentDao {


    private Long id;
    private String name;

    @Id
    private Long phoneNumber;
    private Date date;
    private String email;
    private int age;
}
