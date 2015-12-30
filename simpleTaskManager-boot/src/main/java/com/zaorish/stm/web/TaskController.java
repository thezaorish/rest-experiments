package com.zaorish.stm.web;

import com.zaorish.stm.commons.service.CrudService;
import com.zaorish.stm.commons.web.CrudController;
import com.zaorish.stm.domain.Task;
import com.zaorish.stm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.zaorish.stm.commons.web.RequestConstants.*;

@Controller
@RequestMapping("/tasks")
public class TaskController extends CrudController<Task> {

    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final Task resource) {
        createInternal(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Task> filterByProject(@RequestParam(value = "projectId", required = true) Long projectId) {
        return taskService.findAllByProject(projectId);
    }

    @RequestMapping(params = {PAGE, SIZE}, method = RequestMethod.GET)
    @ResponseBody
    public List<Task> findPaginated(@RequestParam(value = PAGE) final int page, @RequestParam(value = SIZE) final int size) {
        return taskService.findPaginated(page, size);
    }

    // get sorted by priority

    // get sorted by priority (filtered by project)

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody @Valid final Task resource) {
        updateInternal(id, resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteInternal(id);
    }

    @Override
    protected CrudService<Task> getService() {
        return taskService;
    }

}
