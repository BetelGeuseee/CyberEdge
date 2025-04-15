package com.project.cyberedge.repository;


import com.project.cyberedge.model.ProjectDiscussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDiscussionRepository extends JpaRepository<ProjectDiscussion, Integer> {
}
