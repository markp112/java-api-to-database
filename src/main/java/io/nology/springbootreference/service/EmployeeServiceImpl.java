package io.nology.springbootreference.service;

import io.nology.springbootreference.dao.EmployeeDAO;
import io.nology.springbootreference.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO theEmployeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.theEmployeeDAO = theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return theEmployeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return theEmployeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        theEmployeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        theEmployeeDAO.deleteById(theId);
    }

    @Override
    @Transactional
    public List<Employee> findByJobId(int jobId) {
        return theEmployeeDAO.findByJobId(jobId);
    }
}
