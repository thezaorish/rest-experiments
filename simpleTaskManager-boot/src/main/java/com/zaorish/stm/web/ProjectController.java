package com.zaorish.stm.web;

import com.zaorish.stm.domain.Project;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private List<Project> allProjects;

    public ProjectController() {
        allProjects = mockAllProjects();
    }
    private List<Project> mockAllProjects() {
        List<Project> allProjects = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            allProjects.add(new Project(Long.valueOf(i), "project_" + i));
        }
        return allProjects;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid final Project resource) {
        allProjects.add(resource);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Project> findAll() {
        return allProjects;
    }

}
