package io.nology.springbootreference.dao;

import io.nology.springbootreference.entity.Employee;

import javax.validation.constraints.Email;
import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteById(int theId);

    List<Employee> findByJobId(int jobId);
}
