package com.project.cyberedge.repository;

import com.project.cyberedge.model.ProjectResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourcesRepository extends JpaRepository<ProjectResources, Integer> {
}
