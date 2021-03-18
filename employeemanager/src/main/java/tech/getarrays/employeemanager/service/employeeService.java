package tech.getarrays.employeemanager.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repositore.EmployeeRepo;

@Service
public class EmployeeService {
    
    private final EmployeeRepo employeeRepo;
    
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

   
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        // Podemos Usar employeeRepo.findById(id).get() para buscar os dados, Mas não
        // teremos a proteção OPTINAL
        return employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("no há Employee com id " + id));
        
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

}// end class
