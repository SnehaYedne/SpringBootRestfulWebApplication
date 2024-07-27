package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Repository;

import com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
