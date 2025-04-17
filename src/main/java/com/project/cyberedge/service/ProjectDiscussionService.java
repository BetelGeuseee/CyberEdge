package com.project.cyberedge.service;

import com.project.cyberedge.dto.ProjectDTO;
import com.project.cyberedge.model.Project;
import com.project.cyberedge.model.ProjectDiscussion;
import com.project.cyberedge.model.User;
import com.project.cyberedge.repository.ProjectDiscussionRepository;
import com.project.cyberedge.repository.ProjectRepository;
import com.project.cyberedge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectDiscussionService {
    private final ProjectDiscussionRepository projectDiscussionRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public void create(ProjectDTO.ProjectDiscussionRequest projectDiscussionRequest) {
        ProjectDiscussion projectDiscussion = new ProjectDiscussion();
        projectDiscussion.setDiscussion(projectDiscussionRequest.getDiscussion());
        User user = userRepository.findById(projectDiscussionRequest.getUserId()).orElseThrow(()->new RuntimeException("User Not Found"));
        Project project = projectRepository.findById(projectDiscussionRequest.getProjectId()).orElseThrow(()->new RuntimeException("Project Not Found"));
        projectDiscussion.setUser(user);
        projectDiscussion.setProject(project);
        projectDiscussionRepository.save(projectDiscussion);
    }

    public ProjectDTO.ProjectDiscussionResponse getProjectDiscussion(Integer projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()->new RuntimeException("Project not found"));
        List<ProjectDiscussion> projectDiscussions = projectDiscussionRepository.findAllByProjectId(projectId);
        if(!projectDiscussions.isEmpty()){
            List<ProjectDTO.ProjectDiscussionDTO> projectDiscussionDTOS = projectDiscussions.stream()
                    .map(ProjectDTO.ProjectDiscussionDTO::from).toList();
            return ProjectDTO.ProjectDiscussionResponse.from(project,projectDiscussionDTOS);
        }
        return null;
    }
}
