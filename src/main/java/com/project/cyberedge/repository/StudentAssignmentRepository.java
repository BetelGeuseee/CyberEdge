package com.project.cyberedge.repository;

import com.project.cyberedge.model.StudentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, Integer> {

    List<StudentAssignment> findAllByAssignmentId(Integer id);

}

