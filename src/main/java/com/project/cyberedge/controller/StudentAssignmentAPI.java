package com.project.cyberedge.controller;


import com.project.cyberedge.dto.ApiResponse;
import com.project.cyberedge.dto.AssignmentDTO;
import com.project.cyberedge.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/assignment")
public class StudentAssignmentAPI {

    private final AssignmentService assignmentService;

    @PostMapping(path="publish",consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.ALL_VALUE})
    public ResponseEntity<ApiResponse<Void>> createAssignment(@ModelAttribute AssignmentDTO.StudentAssignmentRequest assignmentRequest) {
        assignmentService.uploadStudentAssignment(assignmentRequest);
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .status(200)
                .message("Assignment Uploaded Successfully!")
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
