package tech.getarrays.employeemanager.repositore;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

    // Employee findemployeeById(Long id);

    
}// end class

