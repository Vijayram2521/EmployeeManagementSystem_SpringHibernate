package com.vjulakan.ems_backend.service;

import com.vjulakan.ems_backend.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long EmployeeId);
}
