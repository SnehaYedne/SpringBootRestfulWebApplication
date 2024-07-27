package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Service;

import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity.Employer;
import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Repository.EmployerRepository;
import org.apache.el.util.Validation;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public List<Employer> getAllEmployer(){

        return  employerRepository.findAll();
    }

    public Optional<Employer> getEmployerById(Long id){
        return employerRepository.findById(id);
    }
    public Employer createEmployer(@Validated Employer employer){
        return  employerRepository.save(employer);
    }

    public Optional<Employer>updateEmployer(Long id,Employer employerDetails){
        Optional<Employer> existingEmployer= employerRepository.findById(id);
        if(existingEmployer.isPresent()){
            Employer updatedEmployer= existingEmployer.get();
            updatedEmployer.setName(employerDetails.getName());
            updatedEmployer.setAddress(employerDetails.getAddress());
            updatedEmployer.setContactEmail(employerDetails.getContactEmail());
            updatedEmployer.setContactPhone(employerDetails.getContactPhone());
            return Optional.of(employerRepository.save(updatedEmployer));

        }
           return Optional.empty();
    }

    public boolean deleteEmployer(Long id) {
        if (employerRepository.existsById(id)) {
            employerRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
