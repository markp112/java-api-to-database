package io.nology.springbootreference.service;


import io.nology.springbootreference.entity.Job;

import java.util.List;

public interface JobService {
    public List<Job> findAll();
    public Job findById(int theId);
    public void save(Job theJob);
    public void deleteById(int theId);
}
