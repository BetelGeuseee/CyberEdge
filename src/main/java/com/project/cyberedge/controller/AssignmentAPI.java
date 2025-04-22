package com.project.cyberedge.controller;

import com.project.cyberedge.dto.ApiResponse;
import com.project.cyberedge.dto.AssignmentDTO;
import com.project.cyberedge.dto.DiscussionDTO;
import com.project.cyberedge.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor/assignment")
public class AssignmentAPI {
    private final AssignmentService assignmentService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Void>> createAssignment(@RequestBody AssignmentDTO.AssignmentRequest assignmentRequest) {
        assignmentService.create(assignmentRequest);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Assignment Created Successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<AssignmentDTO.AssignmentResponse>> getAssignment(@PathVariable Integer id) {
        ApiResponse<AssignmentDTO.AssignmentResponse> response = ApiResponse.<AssignmentDTO.AssignmentResponse>builder()
                .success(true)
                .status(200)
                .data(assignmentService.getAssignment(id))
                .message("Assignment Retrieved Successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
