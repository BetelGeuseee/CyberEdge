package com.project.cyberedge.repository;


import com.project.cyberedge.model.ProjectProposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectProposalRepository  extends JpaRepository<ProjectProposal, Integer> {
}
