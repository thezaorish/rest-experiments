package com.zaorish.stm.service;

import com.zaorish.stm.domain.Project;

import java.util.List;

public interface ProjectService {

    Project create(Project project);

    Project find(Long id);

    List<Project> findAll();

}
