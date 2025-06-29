package com.example.portfolio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequest {

    @NotBlank(message = "Project name must not be blank")
    private String name;

    @Size(max = 1000, message = "Description can't exceed 1000 characters")
    private String description;

    @NotBlank(message = "Technologies must not be blank")
    private String technologies;

    private String link;

    @NotNull(message = "User ID is required")
    private Long userId;
}
