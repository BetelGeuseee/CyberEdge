package com.project.cyberedge.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@RequiredArgsConstructor
public class AssignmentDTO {
    @Data
    public static class AssignmentRequest{
        private String assignmentname;
        private LocalDate deadline;

    }
}
