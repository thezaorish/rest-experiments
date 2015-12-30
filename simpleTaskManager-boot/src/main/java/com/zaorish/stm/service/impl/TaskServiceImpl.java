package com.zaorish.stm.service.impl;

import com.zaorish.stm.domain.Project;
import com.zaorish.stm.domain.Task;
import com.zaorish.stm.persistence.dao.TaskJpaDao;
import com.zaorish.stm.service.ProjectService;
import com.zaorish.stm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

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

}
