package com.project.cyberedge.dto;


import com.project.cyberedge.model.Project;
import com.project.cyberedge.model.ProjectDiscussion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class ProjectDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProjectRequest {
        private String name;
        private String description;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProjectProposalRequest {
        private MultipartFile proposalFile;
        private Integer projectId;
        private Integer userId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProjectMemberRequest {
        private MultipartFile proposalFile;
        private Integer projectId;
        private List<Integer> userIds;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProjectDiscussionRequest {
        private String discussion;
        private Integer projectId;
        private Integer userId;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProjectDiscussionResponse{
        private Integer id;
        private String name;
        private String description;
        private List<ProjectDiscussionDTO> projectDiscussions;

        public static ProjectDiscussionResponse from(Project project,List<ProjectDiscussionDTO> projectDiscussions) {
            ProjectDiscussionResponse projectDiscussionResponse = new ProjectDiscussionResponse();
            projectDiscussionResponse.setId(project.getId());
            projectDiscussionResponse.setName(project.getName());
            projectDiscussionResponse.setDescription(project.getDescription());
            projectDiscussionResponse.setProjectDiscussions(projectDiscussions);

            return projectDiscussionResponse;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProjectDiscussionDTO{
      private String discussion;
      private Integer memberId;
      private String memberName;

      public static ProjectDiscussionDTO from(ProjectDiscussion projectDiscussion){
          ProjectDiscussionDTO projectDiscussionDTO = new ProjectDiscussionDTO();
          projectDiscussionDTO.setDiscussion(projectDiscussion.getDiscussion());
          projectDiscussionDTO.setMemberId(projectDiscussion.getUser().getId());
          projectDiscussionDTO.setMemberName(projectDiscussion.getUser().getFirstName()+" "+projectDiscussion.getUser().getLastName());
          return projectDiscussionDTO;
      }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProjectResponse {
        private Integer id;
        private String name;
        private String description;
        private List<UserDTO.UserResponseDTO> members;
        public static ProjectResponse from(Project project) {
            ProjectResponse response = new ProjectResponse();
            response.setId(project.getId());
            response.setName(project.getName());
            response.setDescription(project.getDescription());
            return response;
        }

        public static ProjectResponse from(Project project, List<UserDTO.UserResponseDTO> members) {
            ProjectResponse response = from(project);
            response.setMembers(members);
            return response;
        }

    }

}
