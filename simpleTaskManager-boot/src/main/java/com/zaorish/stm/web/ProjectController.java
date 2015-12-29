package com.zaorish.stm.web;

import com.zaorish.stm.domain.Project;
import com.zaorish.stm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        projectService.createProject(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Project> findAll() {
        return null;
    }

}
