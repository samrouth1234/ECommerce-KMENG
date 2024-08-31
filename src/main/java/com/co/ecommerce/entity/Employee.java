package com.co.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees_db")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(length = 220, nullable = false)
    private String lastName;

    @Column(length = 220, nullable = false)
    private String firstName;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;

    @Column(length = 220, nullable = false)
    private String photo;

    @Column(length = 220, nullable = false)
    private String address;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}