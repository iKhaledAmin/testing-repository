package com.example.erp.service.impl;
import com.example.erp.model.dto.EmployeeDTO;
import com.example.erp.model.dto.EmployeeResDTO;
import com.example.erp.model.dto.EmployeeUpdateReqDTO;
import com.example.erp.model.entity.Employee;
import com.example.erp.model.mapper.impl.EmployeeMapper;
import com.example.erp.repository.EmployeeRepo;
import com.example.erp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeResDTO save(EmployeeDTO employeeReqDTO){
        Employee employee = this.employeeMapper.toEntity(employeeReqDTO);
        this.employeeRepo.save(employee);
        return this.employeeMapper.toResDTO(employee);
    }



    @Override
    public EmployeeResDTO update(EmployeeUpdateReqDTO employeeReqDTO) {
        Employee employee = this.employeeMapper.toEntity(employeeReqDTO);
        Employee updatedEmployee = this.employeeRepo.save(employee);
        return this.employeeMapper.toResDTO(updatedEmployee);
    }

    @Override
    public void delete(Long id) {
        Optional<Employee> employee = this.employeeRepo.findById(id);
        employee.get().setDeletedAt(LocalDateTime.now());
        this.employeeRepo.save(employee.get());
    }

    @Override
    public EmployeeDTO get(Long id) {
        Optional<Employee> employee = this.employeeRepo.findById(id);
        return this.employeeMapper.toDTO(employee.get());
    }

}

