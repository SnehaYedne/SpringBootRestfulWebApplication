package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Controller;

import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity.Employer;
import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/employers")
//@Api(tags = "Employers API")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping
    //@ApiOperation("Get all employers")
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployer();
    }

    @GetMapping("/{id}")
    //@ApiOperation("Get employer by ID")
    public ResponseEntity<Employer> getEmployerById(@PathVariable Long id) {
        Optional<Employer> employer = employerService.getEmployerById(id);
        return employer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    // @ApiOperation("Create a new employer")
    public ResponseEntity<Employer> createEmployer(@Validated @RequestBody Employer employer) {
        Employer createdEmployer = employerService.createEmployer(employer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployer);
    }

    @PutMapping("/{id}")
    // @ApiOperation("Update an existing employer")
    public ResponseEntity<Employer> updateEmployer(@PathVariable Long id, @RequestBody Employer employerDetails) {
        Optional<Employer> updatedEmployer = employerService.updateEmployer(id, employerDetails);
        return updatedEmployer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}