package com.zaorish.stm.service.impl;

import com.google.common.collect.Lists;
import com.zaorish.stm.domain.Project;
import com.zaorish.stm.persistence.dao.ProjectJpaDao;
import com.zaorish.stm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Project create(Project project) {
        return projectJpaDao.save(project);
    }

    @Override
    public Project find(Long id) {
        return projectJpaDao.findOne(id);
    }

    @Override
    public List<Project> findAll() {
        return Lists.newArrayList(projectJpaDao.findAll());
    }

}
