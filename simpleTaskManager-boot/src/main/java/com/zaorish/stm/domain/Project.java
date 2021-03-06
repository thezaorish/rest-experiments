package com.zaorish.stm.domain;

import com.google.common.base.MoreObjects;
import com.zaorish.stm.commons.domain.Resource;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Project implements Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 20)
    @Size(min = 5, max = 20, message = "Name of the project needs to be a string, between 5 and 20 characters")
    @NotNull
    private String name;

    public Project() {
        //
    }
    public Project(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }

}
