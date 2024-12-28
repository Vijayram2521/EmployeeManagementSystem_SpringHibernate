package com.vjulakan.ems_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "First_Name")
    private String firstName ;
    @Column(name = "Last_Name")
    private String lastName ;
    @Column(name = "email_id", nullable = false, unique = true)
    private String email ;
}
