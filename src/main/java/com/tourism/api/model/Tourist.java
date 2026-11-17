package com.tourism.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tourists")
public class Tourist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String fullName;
    @Email @NotBlank @Column(unique = true) private String email;
    private String phone;
    private String country;
    private String preferredDestination;

    public Tourist() {}
    public Tourist(String fullName, String email, String phone, String country, String preferredDestination) {
        this.fullName = fullName; this.email = email; this.phone = phone;
        this.country = country; this.preferredDestination = preferredDestination;
    }
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getPreferredDestination() { return preferredDestination; }
    public void setPreferredDestination(String preferredDestination) { this.preferredDestination = preferredDestination; }
}
