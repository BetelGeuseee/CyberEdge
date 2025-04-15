package com.project.cyberedge.controller;


import com.project.cyberedge.dto.ApiResponse;
import com.project.cyberedge.dto.ProjectDTO;
import com.project.cyberedge.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor/project")
public class ProjectAPI {
    private final ProjectService projectService;

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
