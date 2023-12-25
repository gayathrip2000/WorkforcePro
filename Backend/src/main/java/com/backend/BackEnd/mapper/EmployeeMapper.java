package com.backend.BackEnd.mapper;

import com.backend.BackEnd.dto.EmployeeDto;
import com.backend.BackEnd.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployDto(Employee employee) {
        return new EmployeeDto(

                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployDto(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
