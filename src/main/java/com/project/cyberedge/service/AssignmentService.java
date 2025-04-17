package com.project.cyberedge.service;


import com.project.cyberedge.dto.AssignmentDTO;
import com.project.cyberedge.model.Assignment;
import com.project.cyberedge.repository.AssignmentRepository;
import com.project.cyberedge.repository.StudentAssignmentRepository;
import com.project.cyberedge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final StudentAssignmentRepository studentAssignmentRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;

    public void create(AssignmentDTO.AssignmentRequest assignmentRequest){
        Assignment assignment = new Assignment();
        assignment.setName(assignmentRequest.getAssignmentname());
        assignment.setDeadline(assignmentRequest.getDeadline());
        assignment.setIsActive(true);
        assignmentRepository.save(assignment);
    }

}
