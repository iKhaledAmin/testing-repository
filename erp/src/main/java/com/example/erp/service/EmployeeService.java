package com.example.erp.service;

import com.example.erp.model.dto.EmployeeDTO;
import com.example.erp.model.dto.EmployeeResDTO;
import com.example.erp.model.dto.EmployeeUpdateReqDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    public EmployeeResDTO save(EmployeeDTO employeeReqDTO);


    EmployeeResDTO update(EmployeeUpdateReqDTO employeeReqDTO);

    void delete(Long id);

    EmployeeDTO get(Long id);
}
