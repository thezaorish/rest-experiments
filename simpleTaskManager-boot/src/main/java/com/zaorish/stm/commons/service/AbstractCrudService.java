package com.zaorish.stm.commons.service;

import com.google.common.collect.Lists;
import com.zaorish.stm.commons.domain.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class AbstractCrudService<T extends Resource> implements CrudService<T> {

    @Override
    public T create(T resource) {
        return getDao().save(resource);
    }

    @Override
    public T find(long id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return Lists.newArrayList(getDao().findAll());
    }

    @Override
    public List<T> findPaginated(int page, int size) {
        return findPaginatedAndSorted(page, size, null, null);
    }

    @Override
    public List<T> findPaginatedAndSorted(int page, int size, String sortField, String sortOrder) {
        List<T> resources = getDao().findAll(configurePageable(page, size, sortField, sortOrder)).getContent();
        return resources != null ? resources : Lists.newArrayList();
    }
    protected final PageRequest configurePageable(int page, int size, String sortField, String sortOrder) {
        return new PageRequest(page - 1, size, configureSort(sortField, sortOrder));
    }
    private Sort configureSort(final String sortField, final String sortOrder) {
        return sortField != null ? new Sort(Sort.Direction.fromString(sortOrder), sortField) : null;
    }

    @Override
    public void update(T resource) {
        getDao().save(resource);
    }

    @Override
    public void delete(long id) {
        getDao().delete(id);
    }

    protected abstract PagingAndSortingRepository<T, Long> getDao();

}
