package com.example.portfolio.repository;

import com.example.portfolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByUserId(Long userId);


    List<Project> findByTechnologiesContainingIgnoreCase(String keyword);

    List<Project> findByNameContainingIgnoreCase(String keyword);

}
