package com.project.cyberedge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project extends AbstractEntity{

    @Column(name = "project_name")
    private String name;

    @Column(name = "project_description")
    private String description;

    @Column(name = "is_active")
    private Boolean isActive;

}
