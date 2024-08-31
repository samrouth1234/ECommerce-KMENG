package com.co.ecommerce.service;

import com.co.ecommerce.repository.EmployeeRepository;
import com.co.ecommerce.entity.Employee;
import com.co.ecommerce.web.dto.EmployeeDTO;
import com.co.ecommerce.web.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    // create employee
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.mapEmployeeDTOToEmployee(employeeDTO);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPhoto(employeeDTO.getPhoto());
        employee.setBirthDate(employeeDTO.getBirthDate());
        employeeRepository.save(employee);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employeeMapper::mapEmployeeToEmployeeDTO)
                .collect(Collectors.toList());
    }
}
