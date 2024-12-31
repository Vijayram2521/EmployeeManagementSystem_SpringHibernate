package com.vjulakan.ems_backend.controller;

import com.vjulakan.ems_backend.dto.EmployeeDTO;
import com.vjulakan.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    //Build Add Employee Rest Service
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee Rest Service
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeDTO);
    }

    //Build Get All Employees Rest Service
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeDTOList);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long EmployeeId,@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(EmployeeId, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }
}
