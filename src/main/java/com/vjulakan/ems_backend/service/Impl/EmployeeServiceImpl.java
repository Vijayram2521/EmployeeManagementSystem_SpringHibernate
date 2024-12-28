package com.vjulakan.ems_backend.service.Impl;

import com.vjulakan.ems_backend.dto.EmployeeDTO;
import com.vjulakan.ems_backend.entity.Employee;
import com.vjulakan.ems_backend.exception.ResourceNotFoundException;
import com.vjulakan.ems_backend.mapper.EmployeeMapper;
import com.vjulakan.ems_backend.repository.EmployeeRepository;
import com.vjulakan.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(saved);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long EmployeeId) {
        Employee employee = employeeRepository.findById(EmployeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id : " + EmployeeId +" Does not exist"));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }
}
