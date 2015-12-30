package com.zaorish.stm.commons.web;

import com.zaorish.stm.commons.domain.Resource;
import com.zaorish.stm.commons.service.CrudService;

public abstract class CrudController<T extends Resource> {

    protected final void createInternal(final T resource) {
        getService().create(resource);
    }

    protected final void updateInternal(final long id, final T resource) {
        getService().update(resource);
    }

    protected final void deleteInternal(final long id) {
        getService().delete(id);
    }

    protected abstract CrudService<T> getService();

}
