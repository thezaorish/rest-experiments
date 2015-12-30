package com.zaorish.stm.commons.service;

import com.zaorish.stm.commons.domain.Resource;

import java.util.List;

public interface CrudService<T extends Resource> {

    T create(final T resource);

    T find(final long id);

    List<T> findAll();

    List<T> findPaginated(final int page, final int size);

    List<T> findPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    void update(final T resource);

    void delete(final long id);

}
