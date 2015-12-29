package com.zaorish.stm.web;

import com.zaorish.stm.domain.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Project> findAll() {
        return Collections.emptyList();
    }

}
