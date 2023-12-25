package com.backend.BackEnd.repository;

import com.backend.BackEnd.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
