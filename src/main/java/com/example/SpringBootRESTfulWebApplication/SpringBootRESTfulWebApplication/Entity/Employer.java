package com.example.SpringBootRESTfulWebApplication.SpringBootRESTfulWebApplication.Entity;

import jakarta.persistence.*;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Employer")
public class Employer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="employer_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +

                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }

    @Column(name="address")
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Employer(Long id, String name, String address, String contactEmail, String contactPhone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }



   // @Email(message = "Email should be valid")
   @Column(name="contactEmail")
    private String contactEmail;

    @Column(name="contactPhone")
    private String contactPhone;
}
