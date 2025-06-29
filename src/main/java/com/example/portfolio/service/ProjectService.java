package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectRequest;
import com.example.portfolio.dto.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest request);

    ProjectResponse getProjectById(Long id);

    List<ProjectResponse> getAllProjects();

    ProjectResponse updateProject(Long id, ProjectRequest request);

    void deleteProject(Long id);

    List<ProjectResponse> getProjectsByUserId(Long userId);

    List<ProjectResponse> getProjectsByTechnology(String keyword);

    List<ProjectResponse> getProjectsByName(String keyword);

}
