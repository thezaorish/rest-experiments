package com.zaorish.stm.service.impl;

import com.zaorish.stm.domain.Project;
import com.zaorish.stm.persistence.dao.ProjectJpaDao;
import com.zaorish.stm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectJpaDao projectJpaDao;

    @Autowired
    public ProjectServiceImpl(ProjectJpaDao projectJpaDao) {
        this.projectJpaDao = projectJpaDao;
    }

    @Override
    public Project createProject(Project project) {
        return projectJpaDao.save(project);
    }

}
