package com.project.cyberedge.controller;


import com.project.cyberedge.dto.ApiResponse;
import com.project.cyberedge.dto.ProjectDTO;
import com.project.cyberedge.service.ProjectMemberService;
import com.project.cyberedge.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor/project")
public class ProjectAPI {
    private final ProjectService projectService;
    private final ProjectMemberService projectMemberService;

    @PostMapping("create")
    public ResponseEntity<ApiResponse<Void>> create(@RequestBody ProjectDTO.ProjectRequest projectRequest) {
        projectService.create(projectRequest);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Project created successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<ApiResponse<Void>> update(@RequestBody ProjectDTO.ProjectRequest projectRequest,@PathVariable Integer id) {
        projectService.update(projectRequest,id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Project updated successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("add-member")
    public ResponseEntity<ApiResponse<Void>> create(@RequestBody ProjectDTO.ProjectMemberRequest projectMemberRequest) {
        projectMemberService.createProjectMember(projectMemberRequest);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Project member added successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }


    @GetMapping("members/{projectId}")
    public ResponseEntity<ApiResponse<ProjectDTO.ProjectResponse >> getMembers(@PathVariable Integer projectId) {
        ApiResponse<ProjectDTO.ProjectResponse > response = ApiResponse.<ProjectDTO.ProjectResponse >builder()
                .success(true)
                .status(200)
                .data(projectMemberService.getProjectMembers(projectId))
                .message("Project member fetched successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProject(@PathVariable Integer id) {
        projectService.delete(id);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Project Deleted Successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

}
