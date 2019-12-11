package io.nology.springbootreference.dao;

import io.nology.springbootreference.entity.Employee;
import io.nology.springbootreference.entity.Job;
import io.nology.springbootreference.exceptions.DatabaseValidationException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeDAO {
    // Manages the current implementation of the session so we can access live data
    private EntityManager entityManager;

    // @Autowired for dependency injection
    // Automatically searches for a class/interface that matches EntityManager in the system
    // Setters and fields can also have injection
    @Autowired
    public EmployeeRepository(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return entityManager
                .unwrap(Session.class)
                .createQuery("from Employee", Employee.class)
                .list();
    }

    @Override
    public Employee findById(int theId) {
        return entityManager
                .unwrap(Session.class)
                .find(Employee.class, theId);
    }

    @Override
    public void save(Employee theEmployee) {
        try{
            entityManager
                    .unwrap(Session.class)
                    .saveOrUpdate(theEmployee);
        } catch (ConstraintViolationException exception) {
            handleConstraintViolationException(exception);
        }
        Job createdjob = new Job(theEmployee."new job", 10000);
        entityManager
                .unwrap(Session.class)
                .saveOrUpdate(createdjob);
    }

    @Override
    public void deleteById(int theId) {
        Employee employeeToDelete = findById(theId);
        entityManager.unwrap(Session.class).remove(employeeToDelete);
    }

    @Override
    public List<Employee> findByJobId(int jobId) {
        System.out.println(jobId);
        return entityManager
                .unwrap(Session.class)
                .createQuery("from Employee where job_id="+ jobId, Employee.class)
                .list();
    }

    @ExceptionHandler({ConstraintViolationException.class})
    private void handleConstraintViolationException(ConstraintViolationException exception) throws DatabaseValidationException {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation: exception.getConstraintViolations()) {
            errors.add(
                    violation.getRootBeanClass().getName() + " " +
                            violation.getPropertyPath() + ": " +
                            violation.getMessage());
        }
        throw new DatabaseValidationException(errors.toString());
    }
}
