package com.example.erp.model.mapper.impl;


import com.example.erp.model.dto.EmployeeDTO;
import com.example.erp.model.dto.EmployeeResDTO;
import com.example.erp.model.dto.EmployeeUpdateReqDTO;
import com.example.erp.model.entity.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee toEntity(EmployeeDTO employeeDTO);
    Employee toEntity(EmployeeUpdateReqDTO employeeUpdateReqDTO);
    EmployeeDTO toDTO(Employee employee);
    EmployeeResDTO toResDTO(Employee employee);
}


