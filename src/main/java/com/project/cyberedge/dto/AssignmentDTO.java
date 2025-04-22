package com.project.cyberedge.dto;

import com.project.cyberedge.model.Assignment;
import com.project.cyberedge.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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

    @Data
    public static class StudentAssignmentRequest{
      private Integer assignmentId;
      private Integer studentId;
      private MultipartFile assignmentFile;
    }

    @Data
    public static class AssignmentResponse{
        private Integer assignmentId;
        private String name;
        private LocalDate deadline;
        private List<StudentAssignmentResponse> studentAssignments;

        public static AssignmentResponse from(Assignment assignment,List<StudentAssignmentResponse> studentAssignments){
            AssignmentResponse assignmentResponse = new AssignmentResponse();
            assignmentResponse.setStudentAssignments(studentAssignments);
            assignmentResponse.setAssignmentId(assignment.getId());
            assignmentResponse.setDeadline(assignment.getDeadline());
            assignmentResponse.setName(assignment.getName());

            return assignmentResponse;
        }
    }

    @Data
    public static class StudentAssignmentResponse{
       private UserDTO.UserResponseDTO student;
       private String assignmentPath;

       public static StudentAssignmentResponse from(User user, String assignmentPath){
           StudentAssignmentResponse studentAssignmentResponse = new StudentAssignmentResponse();
           studentAssignmentResponse.setAssignmentPath(assignmentPath);
           studentAssignmentResponse.setStudent(UserDTO.UserResponseDTO.from(user));

           return studentAssignmentResponse;
       }
    }

}
