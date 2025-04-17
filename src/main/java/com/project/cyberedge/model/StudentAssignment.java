package com.project.cyberedge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_assignment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentAssignment extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_user", value = ConstraintMode.CONSTRAINT))
    private User member;

    @ManyToOne
    @JoinColumn(name = "assignment_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_assignment", value = ConstraintMode.CONSTRAINT))
    private Assignment assignment;

    @Column(name = "Assignment_path")
    private String proposalPath;

    @Column(name = "is_active")
    private Boolean isActive;

}
