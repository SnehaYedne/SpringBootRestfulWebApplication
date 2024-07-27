package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Controller;

import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity.JobRole;
import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Service.JobRoleService;
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
@RequestMapping("/api/jobroles")
//@Api(tags = "Job Roles API")
public class JobRoleController {

    @Autowired
    private JobRoleService jobRoleService;

    @GetMapping
   // @ApiOperation("Get all job roles")
    public List<JobRole> getAllJobRoles(){
      return jobRoleService.getAllJobRoles();
    }

    @GetMapping("/{id}")
   // @ApiOperation("Get job role by ID")
    public ResponseEntity<JobRole> getJobRoleBYId(@PathVariable Long id){
        Optional<JobRole> jobRole= jobRoleService.getJobRoleById(id);
        return jobRole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    //@ApiOperation("Create a new job role")
    public ResponseEntity<JobRole> createJobRole(@Validated @RequestBody JobRole jobRole){
       JobRole createdJobRole= jobRoleService.createJobRole(jobRole);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdJobRole);

    }

    @PutMapping("/{id}")
    //@ApiOperation("Update an existing job role")
    public ResponseEntity<JobRole> updateJobRole(@PathVariable Long id,  @RequestBody  JobRole jobRoleDetails){
        Optional<JobRole> updatedJobRole= jobRoleService.updateJobRole(id, jobRoleDetails);
        return updatedJobRole.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
   // @ApiOperation("Delete a job role")
    public ResponseEntity<Void> deleteJobRole(@PathVariable Long id){
        if(jobRoleService.deleteJobRole(id)){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
