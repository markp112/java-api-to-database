package io.nology.springbootreference.dao;

import io.nology.springbootreference.entity.Job;
import io.nology.springbootreference.exceptions.DatabaseValidationException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepository implements JobDAO {
    private EntityManager em;

    @Autowired
    public JobRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Job> findAll() {
        return em.unwrap(Session.class)
                .createQuery("from Job", Job.class)
                .list();
    }

    @Override
    public Job findById(int theId) {
        return em.unwrap(Session.class)
                .find(Job.class, theId);
    }

    @Override
    public void save(Job theJob) {
        try{
            em.unwrap(Session.class)
                .saveOrUpdate(theJob);
        } catch (ConstraintViolationException exception) {
            handleConstraintViolationException(exception);
        } catch (TransactionSystemException exception) {
            handleTransactionSystemException(exception);
        }
    }

    @Override
    public void deleteById(int theId) {
        Job jobToDelete = findById(theId);
        em.unwrap(Session.class).remove(jobToDelete);
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

    @ExceptionHandler({RollbackException.class})
    private void handleTransactionSystemException(TransactionSystemException exception) {
        System.out.println(exception);
    }
}
