package com.example.portfolio.service;

import com.example.portfolio.dto.ProjectRequest;
import com.example.portfolio.dto.ProjectResponse;
import com.example.portfolio.entity.Project;
import com.example.portfolio.entity.User;
import com.example.portfolio.exception.ProjectNotFoundException;
import com.example.portfolio.exception.UserNotFoundException;
import com.example.portfolio.repository.ProjectRepository;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + request.getUserId()));

        Project project = Project.builder()
                .name(request.getName())
                .description(request.getDescription())
                .technologies(request.getTechnologies())
                .link(request.getLink())
                .user(user)
                .build();

        Project saved = projectRepository.save(project);
        return mapToResponse(saved);
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
        return mapToResponse(project);
    }

    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + request.getUserId()));

        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setTechnologies(request.getTechnologies());
        existing.setLink(request.getLink());
        existing.setUser(user);

        Project updated = projectRepository.save(existing);
        return mapToResponse(updated);
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("Project not found with id: " + id));
        projectRepository.delete(project);
    }

    @Override
    public List<ProjectResponse> getProjectsByUserId(Long userId) {
        List<Project> projects = projectRepository.findByUserId(userId);
        return projects.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectResponse> getProjectsByTechnology(String keyword) {
        return projectRepository.findByTechnologiesContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProjectResponse> getProjectsByName(String keyword) {
        return projectRepository.findByNameContainingIgnoreCase(keyword)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ProjectResponse mapToResponse(Project project) {
        return ProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .shortDescription(
                        project.getDescription() != null && project.getDescription().length() > 100
                                ? project.getDescription().substring(0, 100) + "..."
                                : project.getDescription()
                )
                .technologies(splitTechnologies(project.getTechnologies()))
                .link(project.getLink())
                .userId(project.getUser().getId())
                .userName(project.getUser().getName())
                .build();
    }


    //daha sonralar ucun
    private String[] splitTechnologies(String technologies) {
        if (technologies == null || technologies.isBlank()) {
            return new String[0];
        }
        return technologies.split("\\s*,\\s*");
    }





}
