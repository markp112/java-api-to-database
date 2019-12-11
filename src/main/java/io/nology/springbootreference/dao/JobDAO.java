package io.nology.springbootreference.dao;

import io.nology.springbootreference.entity.Job;

import java.util.List;

public interface JobDAO {
    public List<Job> findAll();
    public Job findById(int theId);
    public void save(Job theJob);
    public void deleteById(int theId);
}
