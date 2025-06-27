
package com.example.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Layihə adı boş ola bilməz")
    @Size(max = 100, message = "Layihə adı maksimum 100 simvol ola bilər")
    private String name;

    @NotBlank(message = "Description boş ola bilməz")
    @Size(max = 1000, message = "Description maksimum 1000 simvol ola bilər")
    private String description;

    @NotBlank(message = "İstifadə olunan texnologiyalar sahəsi boş ola bilməz")
    private String technologies;

    @NotBlank(message = "Project URL boş ola bilməz")
    private String projectUrl;

    // --- Constructors ---
    public Project() {
    }

    public Project(Long id, String name, String description, String technologies, String projectUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.technologies = technologies;
        this.projectUrl = projectUrl;
    }

    // --- Getters and Setters ---
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String technologies) {
        this.technologies = technologies;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }
}
