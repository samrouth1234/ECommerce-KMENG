package com.co.ecommerce.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
        private Long employeeId;
        private String lastName;
        private String firstName;
        private LocalDate birthDate;
        private String photo;
        private String address;
}
