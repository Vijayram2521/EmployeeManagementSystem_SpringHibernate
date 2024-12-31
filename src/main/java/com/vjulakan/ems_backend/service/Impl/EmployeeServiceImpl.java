package com.vjulakan.ems_backend.service.Impl;

import com.vjulakan.ems_backend.dto.EmployeeDTO;
import com.vjulakan.ems_backend.entity.Employee;
import com.vjulakan.ems_backend.exception.ResourceNotFoundException;
import com.vjulakan.ems_backend.mapper.EmployeeMapper;
import com.vjulakan.ems_backend.repository.EmployeeRepository;
import com.vjulakan.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map((e)->EmployeeMapper.mapToEmployeeDTO(e)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO updateEmployee(Long EmployeeId, EmployeeDTO employeeDTO) {
        Employee e = employeeRepository.findById(EmployeeId).orElseThrow(()->new ResourceNotFoundException("Employee with id : " + EmployeeId +" Does not exist"));
        e.setFirstName(employeeDTO.getFirstName());
        e.setLastName(employeeDTO.getLastName());
        e.setEmail(employeeDTO.getEmail());
        Employee updatedEmployee = employeeRepository.save(e);
        return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
    }
}
