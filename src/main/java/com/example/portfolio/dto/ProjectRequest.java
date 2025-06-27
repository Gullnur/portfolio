package com.example.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

public class ProjectRequest {

    @NotBlank(message = "Layihə adı boş ola bilməz")
    @Size(max = 100, message = "Layihə adı maksimum 100 simvol ola bilər")
    private String name;

    @NotBlank(message = "Description adı boş ola bilməz")
    @Size(max = 1000, message = "Description maksimum 1000 simvol ola bilər")
    private String description;

    @NotBlank(message = "İstifadə olunan texnologiyalar sahəsi boş ola bilməz")
    private String technologies;

    @NotBlank(message = "Project URL boş ola bilməz")
    @URL(message = "Düzgün URL formatı olmalıdır")

    private String projectUrl;

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
