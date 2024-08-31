package com.co.ecommerce.web.mapper;

import com.co.ecommerce.entity.Employee;
import com.co.ecommerce.web.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "employeeId" , source = "employee.employeeId")
    EmployeeDTO mapEmployeeToEmployeeDTO(Employee employee);

    Employee mapEmployeeDTOToEmployee(EmployeeDTO employeeDTO);
}
