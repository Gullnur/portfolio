package com.example.portfolio.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {

    private Long id;

    private String name;

    private String shortDescription;

    private String[] technologies;

    private String link;

    private Long userId;

    private String userName;
}
