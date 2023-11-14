package com.ymh.departmentService.service.Impl;

import com.ymh.departmentService.DTO.DepartmentDTO;
import com.ymh.departmentService.entity.Department;
import com.ymh.departmentService.repository.DepartmentRepository;
import com.ymh.departmentService.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper mapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper mapper) {
        this.departmentRepository = departmentRepository;
        this.mapper = mapper;
    }

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        // convert departmentDTO to department jpa entity
        Department department = mapToEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return mapToDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return mapToDTO(department);
    }

    private DepartmentDTO mapToDTO(Department department) {
        DepartmentDTO departmentDTO = mapper.map(department, DepartmentDTO.class);
        return departmentDTO;
    }

    private Department mapToEntity(DepartmentDTO departmentDTO) {
        Department department = mapper.map(departmentDTO, Department.class);
        return department;
    }
}