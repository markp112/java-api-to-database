package io.nology.springbootreference.rest;

import io.nology.springbootreference.entity.Employee;
import io.nology.springbootreference.exceptions.ResourceNotFoundException;
import io.nology.springbootreference.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // INDEX
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
        return ResponseEntity.status(HttpStatus.OK).body(theEmployee);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(theEmployee);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
        return ResponseEntity.status(HttpStatus.OK).body(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
        employeeService.deleteById(employeeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // HERE
    @GetMapping("/jobs/{jobId}/employees")
    public ResponseEntity<List<Employee>> findAllByJobId(@PathVariable int jobId) {
        List<Employee> employees = employeeService.findByJobId(jobId);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }
}
