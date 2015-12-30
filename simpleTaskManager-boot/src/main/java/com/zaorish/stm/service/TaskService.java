package com.zaorish.stm.service;

import com.zaorish.stm.domain.Task;

import java.util.List;

public interface TaskService {

    Task create(Task task);

    List<Task> findAllByProject(Long projectId);

}
