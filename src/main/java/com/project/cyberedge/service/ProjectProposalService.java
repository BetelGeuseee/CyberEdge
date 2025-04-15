package com.project.cyberedge.service;

import com.project.cyberedge.dto.ProjectDTO;
import com.project.cyberedge.model.Project;
import com.project.cyberedge.model.ProjectProposal;
import com.project.cyberedge.model.User;
import com.project.cyberedge.repository.ProjectProposalRepository;
import com.project.cyberedge.repository.ProjectRepository;
import com.project.cyberedge.repository.UserRepository;
import com.project.cyberedge.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProjectProposalService {

    private final ProjectProposalRepository projectProposalRepository;
    private final FileUtils fileUtils;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public void createProjectProposal(ProjectDTO.ProjectProposalRequest projectProposalRequest) {
        String path = fileUtils.saveAndGetPath(projectProposalRequest.getProposalFile());
        Project project = projectRepository.findById(projectProposalRequest.getProjectId()).orElseThrow(()-> new RuntimeException("Project not found"));
        User user = userRepository.findById(projectProposalRequest.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));

        ProjectProposal projectProposal = new ProjectProposal();
        projectProposal.setProject(project);
        projectProposal.setProposalPath(path);
        projectProposal.setIsActive(true);
        projectProposal.setMember(user);

        projectProposalRepository.save(projectProposal);
    }

    public void deleteProjectProposal(Integer id) {

       ProjectProposal projectProposal =projectProposalRepository.findById(id).orElseThrow(()-> new RuntimeException("Project Proposal not found"));
       projectProposal.setIsActive(true);

       projectProposalRepository.save(projectProposal);
    }
}
