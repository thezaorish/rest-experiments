package com.zaorish.stm.service.impl;

import com.google.common.collect.Lists;
import com.zaorish.stm.domain.Project;
import com.zaorish.stm.persistence.dao.ProjectJpaDao;
import com.zaorish.stm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectJpaDao projectJpaDao;

    @Autowired
    public ProjectServiceImpl(ProjectJpaDao projectJpaDao) {
        this.projectJpaDao = projectJpaDao;
    }

    @Override
    public Project create(final Project project) {
        return projectJpaDao.save(project);
    }

    @Override
    public Project find(final Long id) {
        return projectJpaDao.findOne(id);
    }

    @Override
    public List<Project> findAll() {
        return projectJpaDao.findAll();
    }

    @Override
    public List<Project> findPaginated(int page, int size) {
        return findPaginatedAndSorted(page, size, null, null);
    }

    @Override
    public List<Project> findPaginatedAndSorted(final int page, final int size, final String sortField, final String sortOrder) {
        List<Project> projects = projectJpaDao.findAll(new PageRequest(page - 1, size, configureSort(sortField, sortOrder))).getContent();
        return projects != null ? projects : Lists.newArrayList();
    }
    private Sort configureSort(final String sortField, final String sortOrder) {
        return sortField != null ? new Sort(Sort.Direction.fromString(sortOrder), sortField) : null;
    }

    @Override
    public void update(Long id, Project project) {
        projectJpaDao.save(project);
    }

    @Override
    public void delete(Long id) {
        projectJpaDao.delete(id);
    }

}
