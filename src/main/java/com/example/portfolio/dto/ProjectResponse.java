package com.example.portfolio.dto;

public class ProjectResponse {

    private Long id;
    private String name;
    private String description;
    private String technologies;
    private String projectUrl;

    // --- Constructor ---
    public ProjectResponse(Long id, String name, String description, String technologies, String projectUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.technologies = technologies;
        this.projectUrl = projectUrl;
    }

    // --- Getters ---
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnologies() {
        return technologies;
    }

    public String getProjectUrl() {
        return projectUrl;
    }
}
