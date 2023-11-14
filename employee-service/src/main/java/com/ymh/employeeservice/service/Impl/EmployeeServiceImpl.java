package com.ymh.employeeservice.service.Impl;

import com.ymh.employeeservice.DTO.EmployeeDTO;
import com.ymh.employeeservice.entity.Employee;
import com.ymh.employeeservice.repository.EmployeeRepository;
import com.ymh.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper){
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToDTO(savedEmployee);
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return mapToDTO(employee);
    }

    private EmployeeDTO mapToDTO(Employee employee){
        EmployeeDTO employeeDTO = mapper.map(employee, EmployeeDTO.class);
        return employeeDTO;
    }

    private Employee mapToEntity(EmployeeDTO employeeDTO){
        Employee employee = mapper.map(employeeDTO, Employee.class);
        return employee;
    }
}
