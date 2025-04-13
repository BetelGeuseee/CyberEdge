package com.project.cyberedge.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project_member")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectMember extends AbstractEntity{


    @ManyToOne
    @JoinColumn(name = "project_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_project", value = ConstraintMode.CONSTRAINT))
    private Project project;

    @ManyToOne
    @JoinColumn(name = "member_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_member", value = ConstraintMode.CONSTRAINT))
    private User member;

}
