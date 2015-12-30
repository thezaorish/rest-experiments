package com.zaorish.stm.web;

import com.zaorish.stm.domain.Project;
import com.zaorish.stm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.zaorish.stm.web.RequestConstants.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final Project resource) {
        projectService.create(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @RequestMapping(params = {PAGE, SIZE}, method = RequestMethod.GET)
    @ResponseBody
    public List<Project> findPaginated(@RequestParam(value = PAGE) final int page, @RequestParam(value = SIZE) final int size) {
        return projectService.findPaginated(page, size);
    }

    @RequestMapping(params = {PAGE, SIZE, SORT_FIELD, SORT_ORDER}, method = RequestMethod.GET)
    @ResponseBody
    public List<Project> findAllPaginatedAndSorted(@RequestParam(value = PAGE) final int page, @RequestParam(value = SIZE) final int size,
                                                   @RequestParam(value = SORT_FIELD) final String sortField, @RequestParam(value = SORT_ORDER) final String sortOrder) {
        return projectService.findPaginatedAndSorted(page, size, sortField, sortOrder);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final Long id, @RequestBody @Valid final Project resource) {
        projectService.update(id, resource);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        projectService.delete(id);
    }

}
