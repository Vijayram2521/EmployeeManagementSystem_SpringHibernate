package com.vjulakan.ems_backend.mapper;

import com.vjulakan.ems_backend.dto.EmployeeDTO;
import com.vjulakan.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static Employee mapToEmployee(EmployeeDTO employeeDTO) {
        return new Employee(employeeDTO.getId(), employeeDTO.getFirstName(), employeeDTO.getLastName(), employeeDTO.getEmail()) ;
    }
    public static EmployeeDTO mapToEmployeeDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
    }
}