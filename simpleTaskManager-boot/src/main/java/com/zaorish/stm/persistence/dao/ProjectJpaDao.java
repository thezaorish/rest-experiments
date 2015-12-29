package com.zaorish.stm.persistence.dao;

import com.zaorish.stm.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaDao extends JpaRepository<Project, Long> {

    //

}
