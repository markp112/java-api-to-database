package io.nology.springbootreference.rest;

import io.nology.springbootreference.entity.Job;
import io.nology.springbootreference.exceptions.ResourceNotFoundException;
import io.nology.springbootreference.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobRestController {
    private JobService JobService;

    @Autowired
    public JobRestController(JobService theJobService) {
        this.JobService = theJobService;
    }

    // INDEX
    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll() {
        List<Job> jobs = JobService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

    @GetMapping("/jobs/{jobId}")
    public ResponseEntity<Job> getJob(@PathVariable int jobId) {
        Job theJob = JobService.findById(jobId);
        if (theJob == null) throw new ResourceNotFoundException("Job not found with id: " + jobId);
        return ResponseEntity.status(HttpStatus.OK).body(theJob);
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> addJob(@RequestBody Job theJob) {
        theJob.setId(0);
        JobService.save(theJob);
        return ResponseEntity.status(HttpStatus.CREATED).body(theJob);
    }

    @PutMapping("/jobs")
    public ResponseEntity<Job> updateJob(@RequestBody Job theJob) {
        JobService.save(theJob);
        return ResponseEntity.status(HttpStatus.OK).body(theJob);
    }

    @DeleteMapping("/jobs/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable int jobId) {
        Job theJob = JobService.findById(jobId);
        if (theJob == null) throw new ResourceNotFoundException("Job not found with id: " + jobId);
        JobService.deleteById(jobId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}