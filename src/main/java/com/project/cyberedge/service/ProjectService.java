package com.project.cyberedge.service;


import com.project.cyberedge.dto.ProjectDTO;
import com.project.cyberedge.model.Project;
import com.project.cyberedge.model.ProjectResources;
import com.project.cyberedge.repository.ProjectRepository;
import com.project.cyberedge.repository.ProjectResourcesRepository;
import com.project.cyberedge.repository.UserRepository;
import com.project.cyberedge.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final FileUtils fileUtils;
    private final ProjectResourcesRepository projectResourcesRepository;

    public void create(ProjectDTO.ProjectRequest request) {
        Project project = new Project();
        project.setName(request.getName());
        project.setDescription(request.getDescription());
        projectRepository.save(project);
    }

    public void update(ProjectDTO.ProjectRequest request,Integer id) {
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found"));

        project.setName(request.getName());
        project.setDescription(request.getDescription());

        projectRepository.save(project);
    }

    public void delete(Integer id) {
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found"));
        project.setIsActive(false);
        projectRepository.save(project);
    }

    public List<ProjectDTO.ProjectResponse> getProjects() {
       return projectRepository.findAll().stream()
                .filter(Project::getIsActive).map(ProjectDTO.ProjectResponse::from).toList();
    }

    public ProjectDTO.ProjectResponse getProject(Integer id) {
        Project project = projectRepository.findById(id).orElseThrow(()-> new RuntimeException("Project not found"));

        return ProjectDTO.ProjectResponse.from(project);
    }

    public void publish(ProjectDTO.ProjectResourceRequest request) {
        String path = fileUtils.saveAndGetPath(request.getResourceFile());
        Project project = projectRepository.findById(request.getProjectId()).orElseThrow(()-> new RuntimeException("Project not found"));
        ProjectResources projectResource = new ProjectResources();
        projectResource.setProject(project);
        projectResource.setResourcesPath(path);
        projectResourcesRepository.save(projectResource);


    }


}
