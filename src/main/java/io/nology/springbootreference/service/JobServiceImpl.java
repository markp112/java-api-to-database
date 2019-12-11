package io.nology.springbootreference.service;

import io.nology.springbootreference.dao.JobDAO;
import io.nology.springbootreference.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private JobDAO theJobDao;

    @Autowired
    public JobServiceImpl(JobDAO theJobDao) {
        this.theJobDao = theJobDao;
    }

    @Override
    @Transactional
    public List<Job> findAll() {
        return theJobDao.findAll();
    }

    @Override
    @Transactional
    public Job findById(int theId) {
        return theJobDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Job theJob) {
        theJobDao.save(theJob);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        theJobDao.deleteById(theId);
    }
}
