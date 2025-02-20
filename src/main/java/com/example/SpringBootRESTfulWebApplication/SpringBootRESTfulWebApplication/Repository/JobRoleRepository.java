package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Repository;

import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
}
