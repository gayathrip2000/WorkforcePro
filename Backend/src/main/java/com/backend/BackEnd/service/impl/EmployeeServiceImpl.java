package com.backend.BackEnd.service.impl;

import com.backend.BackEnd.dto.EmployeeDto;
import com.backend.BackEnd.entity.Employee;
import com.backend.BackEnd.mapper.EmployeeMapper;
import com.backend.BackEnd.repository.EmployeeRepository;
import com.backend.BackEnd.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployDto(employeeDto);
        Employee saveEmployee =employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployDto(saveEmployee);
    }
}
