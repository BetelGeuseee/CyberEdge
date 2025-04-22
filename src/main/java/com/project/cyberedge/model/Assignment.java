package com.project.cyberedge.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "assignment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Assignment extends AbstractEntity {

    @Column(name = "assignment_name")
    private String name;

   @Column(name="deadline")
   private LocalDate deadline;

    @Column(name = "is_active")
    private Boolean isActive;


}
