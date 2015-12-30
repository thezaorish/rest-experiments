package com.zaorish.stm.persistence.dao;

import com.zaorish.stm.domain.Project;
import com.zaorish.stm.domain.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskJpaDao extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t where t.project.id = :id")
    List<Task> findByProjectId(@Param("id") Long projectId);

    List<Task> findByProject(Project project, Pageable pageable);

}
