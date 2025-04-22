package com.project.cyberedge.service;


import com.project.cyberedge.dto.AssignmentDTO;
import com.project.cyberedge.model.*;
import com.project.cyberedge.repository.AssignmentRepository;
import com.project.cyberedge.repository.StudentAssignmentRepository;
import com.project.cyberedge.repository.UserRepository;
import com.project.cyberedge.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final StudentAssignmentRepository studentAssignmentRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final FileUtils fileUtils;

    @Value("${backend.domain}")
    private String domain;

    public void create(AssignmentDTO.AssignmentRequest assignmentRequest){
        Assignment assignment = new Assignment();
        assignment.setName(assignmentRequest.getAssignmentname());
        assignment.setDeadline(assignmentRequest.getDeadline());
        assignment.setIsActive(true);
        assignmentRepository.save(assignment);
    }

    public void uploadStudentAssignment(AssignmentDTO.StudentAssignmentRequest studentAssignmentRequest){
        String path = fileUtils.saveAndGetPath(studentAssignmentRequest.getAssignmentFile());
        Assignment assignment = assignmentRepository.findById(studentAssignmentRequest.getAssignmentId()).orElseThrow(()-> new RuntimeException("Assignment not found"));
        User user = userRepository.findById(studentAssignmentRequest.getStudentId()).orElseThrow(()-> new RuntimeException("Student not found"));

        StudentAssignment studentAssignment = new StudentAssignment();
        studentAssignment.setAssignment(assignment);
        studentAssignment.setMember(user);
        studentAssignment.setAssignmentPath(path);
        studentAssignmentRepository.save(studentAssignment);

    }

    public AssignmentDTO.AssignmentResponse getAssignment(Integer assignmentId){
        Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow(()-> new RuntimeException("Assignment not found"));

        List<StudentAssignment> studentAssignments = studentAssignmentRepository.findAllByAssignmentId(assignmentId);

        if(!studentAssignments.isEmpty()){
            List<AssignmentDTO.StudentAssignmentResponse> studentAssignmentResponses = studentAssignments.stream().map(studentAssignment -> AssignmentDTO.StudentAssignmentResponse.from(studentAssignment.getMember(),studentAssignment.getAssignmentPath())).toList();
            return AssignmentDTO.AssignmentResponse.from(assignment,studentAssignmentResponses);
        }
        return AssignmentDTO.AssignmentResponse.from(assignment,null);
    }

}
