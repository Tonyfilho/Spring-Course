package tech.getarrays.employeemanager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

   private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    

    
}// end class
