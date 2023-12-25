package com.backend.BackEnd.service.impl;

import com.backend.BackEnd.dto.EmployeeDto;
import com.backend.BackEnd.entity.Employee;
import com.backend.BackEnd.exception.ResourceNotFoundException;
import com.backend.BackEnd.mapper.EmployeeMapper;
import com.backend.BackEnd.repository.EmployeeRepository;
import com.backend.BackEnd.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
      Employee employee =  employeeRepository.findById(employeeId)
        .orElseThrow(() ->
                new ResourceNotFoundException("Employee is not exist given id: " + employeeId));
        return EmployeeMapper.mapToEmployDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist given id" +employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj =employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee =  employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist given id: " + employeeId));
      employeeRepository.deleteById(employeeId);
    }


}
