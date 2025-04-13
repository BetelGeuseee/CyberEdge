package com.project.cyberedge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_Discussion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectDiscussion extends AbstractEntity {


    @ManyToOne
    @JoinColumn(name = "project_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_project", value = ConstraintMode.CONSTRAINT))
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_user", value = ConstraintMode.CONSTRAINT))
    private User user;

    @Column(name = "Discussion")
    private String discussion;

    // Getters and setters
}
