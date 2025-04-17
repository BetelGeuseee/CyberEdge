package com.project.cyberedge.service;


import com.project.cyberedge.dto.ProjectDTO;
import com.project.cyberedge.dto.UserDTO;
import com.project.cyberedge.model.Project;
import com.project.cyberedge.model.ProjectMember;
import com.project.cyberedge.model.User;
import com.project.cyberedge.repository.ProjectMemberRepository;
import com.project.cyberedge.repository.ProjectRepository;
import com.project.cyberedge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberService {
    private final ProjectMemberRepository projectMemberRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public void createProjectMember(ProjectDTO.ProjectMemberRequest projectDTO) {
        Project project = projectRepository.findById(projectDTO.getProjectId()).orElseThrow(()-> new RuntimeException("Project not found"));
        List<User> members = userRepository.findAllById(projectDTO.getUserIds());
        if(!members.isEmpty()){
            List<ProjectMember> projectMembers = new ArrayList<>();
            members.forEach(member -> {
                ProjectMember projectMember = new ProjectMember();
                projectMember.setProject(project);
                projectMember.setMember(member);
                projectMembers.add(projectMember);
            });
            projectMemberRepository.saveAll(projectMembers);
        }
    }

    public ProjectDTO.ProjectResponse getProjectMembers(Integer projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(()-> new RuntimeException("Project not found"));
        List<ProjectMember> projectMembers = projectMemberRepository.findByProjectId(project.getId());
        List<UserDTO.UserResponseDTO> members = new ArrayList<>();
        projectMembers.forEach(member -> {
           members.add(UserDTO.UserResponseDTO.from(member.getMember()));
       });
       return ProjectDTO.ProjectResponse.from(project,members);
    }

}
