package com.project.cyberedge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_resources")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectResources extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "project_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_project", value = ConstraintMode.CONSTRAINT))
    private Project project;

    @Column(name = "resources_path")
    private String resourcesPath;

}
