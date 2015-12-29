package com.zaorish.stm.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Project {

    private Long id;

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
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
