package com.project.cyberedge.repository;

import com.project.cyberedge.model.StudentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Integer> {

}

