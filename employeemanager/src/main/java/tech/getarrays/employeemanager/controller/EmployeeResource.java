package tech.getarrays.employeemanager.controller;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

   private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/") 
    public ResponseEntity<List<Employee>> all(){
        return getAllEmployees();
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee>getEmployeesById (@PathVariable("id") Long id) {
        Employee employees = employeeService.findEmployeeById(id);
        return new ResponseEntity<Employee>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Employee>upDateEmployee(@RequestBody Employee employee){
      Employee updateEmployee = employeeService.updateEmployee(employee);
      return new ResponseEntity<>(updateEmployee, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee>deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    
}// end class
