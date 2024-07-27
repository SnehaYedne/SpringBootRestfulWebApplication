package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Service;

import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity.JobRole;
import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Repository.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class JobRoleService {

    @Autowired
    private JobRoleRepository jobRoleRepository;

    public List<JobRole> getAllJobRoles(){
     return  jobRoleRepository.findAll();
    }

    public Optional<JobRole> getJobRoleById(Long id){
        return jobRoleRepository.findById(id);
    }

    public JobRole createJobRole( @Validated JobRole jobRole){
        return jobRoleRepository.save(jobRole);
    }

    public Optional<JobRole>updateJobRole(Long id, JobRole jobRoleDetails) {
        Optional<JobRole> existingJobRole = jobRoleRepository.findById(id);
        if (existingJobRole.isPresent()) {
            JobRole updatedJobRole = existingJobRole.get();
            updatedJobRole.setTitle(jobRoleDetails.getTitle());
            updatedJobRole.setDescription(jobRoleDetails.getDescription());
            updatedJobRole.setQualification(jobRoleDetails.getQualification());
            updatedJobRole.setExperience(jobRoleDetails.getExperience());
            updatedJobRole.setPostedDate(jobRoleDetails.getPostedDate());
            updatedJobRole.setSalary(jobRoleDetails.getSalary());

            return Optional.of(jobRoleRepository.save(updatedJobRole));
        }
            return Optional.empty();

    }
      public  boolean deleteJobRole(Long id){
        if(jobRoleRepository.existsById(id)){
            jobRoleRepository.deleteById(id);
            return true;
        }
        return false;
      }


}
