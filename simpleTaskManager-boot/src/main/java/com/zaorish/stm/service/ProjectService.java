package com.zaorish.stm.service;

import com.zaorish.stm.domain.Project;

import java.util.List;

public interface ProjectService {

    Project create(Project project);

    Project find(Long id);

    List<Project> findAll();

    List<Project> findPaginated(int page, int size);

    List<Project> findPaginatedAndSorted(int page, int size, String sortField, String sortOrder);

    void update(Long id, Project project);

    void delete(Long id);

}
