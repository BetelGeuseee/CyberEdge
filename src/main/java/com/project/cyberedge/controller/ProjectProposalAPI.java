package com.project.cyberedge.controller;


import com.project.cyberedge.dto.ApiResponse;
import com.project.cyberedge.dto.ProjectDTO;
import com.project.cyberedge.service.ProjectDiscussionService;
import com.project.cyberedge.service.ProjectProposalService;
import com.project.cyberedge.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectProposalAPI {
    private final ProjectService projectService;
    private final ProjectProposalService projectProposalService;
    private final ProjectDiscussionService projectDiscussionService;

    @PostMapping(path="create",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.ALL_VALUE})
    public ResponseEntity<ApiResponse<Void>> create(@ModelAttribute ProjectDTO.ProjectProposalRequest projectRequest) {
        projectProposalService.createProjectProposal(projectRequest);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Project Proposal uploaded successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ProjectDTO.ProjectResponse>>> getAllProjects() {
        ApiResponse<List<ProjectDTO.ProjectResponse>> response = ApiResponse.<List<ProjectDTO.ProjectResponse>>builder()
                .success(true)
                .status(200)
                .data(projectService.getProjects())
                .message("Projects retrieved Successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<ProjectDTO.ProjectResponse>> getProject(@PathVariable Integer id) {
        ApiResponse<ProjectDTO.ProjectResponse> response = ApiResponse.<ProjectDTO.ProjectResponse>builder()
                .success(true)
                .status(200)
                .data(projectService.getProject(id))
                .message("Project retrieved Successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/discussion/create")
    public ResponseEntity<ApiResponse<Void>> createProjectDiscussion(@ModelAttribute ProjectDTO.ProjectDiscussionRequest projectRequest) {
        projectDiscussionService.create(projectRequest);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Project Discussion created successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/discussion/{projectId}")
    public ResponseEntity<ApiResponse<ProjectDTO.ProjectDiscussionResponse>> getProjectDiscussions(@PathVariable Integer projectId) {
        ApiResponse<ProjectDTO.ProjectDiscussionResponse> response = ApiResponse.<ProjectDTO.ProjectDiscussionResponse>builder()
                .success(true)
                .status(200)
                .data(projectDiscussionService.getProjectDiscussion(projectId))
                .message("Project Discussion retrieved Successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


}
