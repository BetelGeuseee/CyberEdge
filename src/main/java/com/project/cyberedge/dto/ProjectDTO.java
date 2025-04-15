package com.project.cyberedge.dto;


import com.project.cyberedge.model.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    public static class ProjectResponse {
        private String name;
        private String description;

        public static ProjectResponse from(Project project) {
            ProjectResponse response = new ProjectResponse();
            response.setName(project.getName());
            response.setDescription(project.getDescription());
            return response;
        }
    }
}
