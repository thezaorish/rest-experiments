package com.zaorish.stm.service.impl;

import com.google.common.collect.Lists;
import com.zaorish.stm.commons.service.AbstractCrudService;
import com.zaorish.stm.domain.Project;
import com.zaorish.stm.domain.Task;
import com.zaorish.stm.persistence.dao.TaskJpaDao;
import com.zaorish.stm.service.ProjectService;
import com.zaorish.stm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl extends AbstractCrudService<Task> implements TaskService {

    private TaskJpaDao taskJpaDao;
    private ProjectService projectService;

    @Autowired
    public TaskServiceImpl(TaskJpaDao taskJpaDao, ProjectService projectService) {
        this.taskJpaDao = taskJpaDao;
        this.projectService = projectService;
    }

    @Override
    public Task create(Task task) {
        Project project = projectService.find(task.getProjectId());
        task.setProject(project);
        return taskJpaDao.save(task);
    }

    @Override
    public List<Task> findAllByProject(Long projectId) {
        return taskJpaDao.findByProjectId(projectId);
    }

    @Override
    public List<Task> findAllByProjectPaginatedAndSorted(int page, int size, String sortField, String sortOrder, Long projectId) {
        Project project = projectService.find(projectId);
        List<Task> resources = taskJpaDao.findByProject(project, configurePageable(page, size, sortField, sortOrder));
        return resources != null ? resources : Lists.newArrayList();
    }

    @Override
    protected PagingAndSortingRepository<Task, Long> getDao() {
        return taskJpaDao;
    }

}
