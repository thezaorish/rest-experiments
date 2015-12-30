package com.zaorish.stm.web;

import com.zaorish.stm.domain.Task;
import com.zaorish.stm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final Task resource) {
        taskService.create(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Task> filterByProject(@RequestParam("projectId") Long projectId) {
        return taskService.findAllByProject(projectId);
    }

    // get paginated

    // get sorted by priority

    // get sorted by priority (filtered by project)

    // update

    // delete

}
