package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectRequest;
import com.example.portfolio.dto.ProjectResponse;
import com.example.portfolio.entity.Project;
import com.example.portfolio.exception.ProjectNotFoundException;
import com.example.portfolio.repository.ProjectRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

// update versiona bean yox idi onu elave etdim
    //yeni beani yaratmagi:
    @PostConstruct
    public void init() {
        System.out.println("ProjectServiceImpl bean başladılır!!!!");
    }
    //yaradilan beani destroy elemeyi
    @PreDestroy
    public void destroy() {
        System.out.println("ProjectServiceImpl bean silinir!!!!");
    }
    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Project project = mapToEntity(request);
        Project saved = projectRepository.save(project);
        return mapToResponse(saved);
    }

    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
        return mapToResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setTechnologies(request.getTechnologies());
        project.setProjectUrl(request.getProjectUrl());

        Project updated = projectRepository.save(project);
        return mapToResponse(updated);
    }

    @Override
    public void deleteProject(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }

    // --- Mapper methods ---
    private Project mapToEntity(ProjectRequest request) {
        return new Project(
                null,
                request.getName(),
                request.getDescription(),
                request.getTechnologies(),
                request.getProjectUrl()
        );
    }

    private ProjectResponse mapToResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getTechnologies(),
                project.getProjectUrl()
        );
    }
}
