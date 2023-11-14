package com.ymh.employeeservice.service;

import com.ymh.employeeservice.DTO.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
}
