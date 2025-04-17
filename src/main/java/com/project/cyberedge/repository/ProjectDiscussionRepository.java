package com.project.cyberedge.repository;


import com.project.cyberedge.model.ProjectDiscussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDiscussionRepository extends JpaRepository<ProjectDiscussion, Integer> {
    List<ProjectDiscussion> findAllByProjectId(Integer id);
}
