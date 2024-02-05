package com.example.erp.controller;

import com.example.erp.model.dto.EmployeeDTO;
import com.example.erp.model.dto.EmployeeResDTO;
import com.example.erp.model.dto.EmployeeUpdateReqDTO;
import com.example.erp.service.impl.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;


@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;


    @GetMapping("/employee/{id}")
    public EmployeeDTO getEmployee(@PathVariable Long id){
        log.info("Employee ID {}",id );
        return this.employeeService.get(id);
    }



    @PostMapping("/employee")
    public EmployeeResDTO save(@RequestBody @Valid EmployeeDTO employeeDTO,@RequestHeader("correlationId") String correlationId){
        log.info("Save Employee Request : {} and Name : {} correlationId {} ",employeeDTO ,employeeDTO.getUserName() ,correlationId);
        return this.employeeService.save(employeeDTO);
    }


    @PutMapping ("/employee")
    public EmployeeResDTO update(@RequestBody EmployeeUpdateReqDTO employeeReqDTO){
        return this.employeeService.update(employeeReqDTO);
    }

    @DeleteMapping  ("/employee/{id}")
    public void delete(@PathVariable Long id){
        this.employeeService.delete(id);
    }




}
