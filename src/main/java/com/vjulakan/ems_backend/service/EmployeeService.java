package com.vjulakan.ems_backend.service;
import java.util.List ;
import com.vjulakan.ems_backend.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long EmployeeId);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(Long EmployeeId, EmployeeDTO employeeDTO);
    void deleteEmployee(Long EmployeeId);
}
