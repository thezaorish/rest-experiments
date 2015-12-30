package com.zaorish.stm.service;

import com.zaorish.stm.commons.service.CrudService;
import com.zaorish.stm.domain.Task;

import java.util.List;

public interface TaskService extends CrudService<Task> {

    List<Task> findAllByProject(Long projectId);

}
