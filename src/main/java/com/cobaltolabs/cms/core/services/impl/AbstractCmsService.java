package com.cobaltolabs.cms.core.services.impl;

import com.cobaltolabs.cms.core.DeleteException;
import com.cobaltolabs.cms.core.IdBean;
import com.cobaltolabs.cms.core.InsertException;
import com.cobaltolabs.cms.core.UpdateException;
import com.cobaltolabs.cms.core.daos.CmsDao;
import com.cobaltolabs.cms.core.services.CmsService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 14:03
 */
public abstract class AbstractCmsService<I, T extends IdBean<I>, E extends Exception> implements CmsService<I, T, E> {
// ------------------------ INTERFACE METHODS ------------------------

    private CmsDao<I, T, E> dao;

    @Required
    public void setDao(CmsDao<I, T, E> dao) {
        this.dao = dao;
    }

    // --------------------- Interface CmsService ---------------------

    @Override
    @Transactional(readOnly = true)
    public List<T> getAll() {
        return dao.find();
    }

    @Override
    @Transactional(rollbackFor = {InsertException.class})
    public I insert(T t) throws InsertException {
        return dao.insert(t);
    }

    @Override
    @Transactional(rollbackFor = {DeleteException.class})
    public void delete(T t) throws DeleteException {
        dao.delete(t.getId());
    }

    @Transactional(readOnly = true)
    public T get(I id) throws E{
        return dao.find(id);
    }

    @Override
    @Transactional(rollbackFor = {UpdateException.class})
    public void update(T t) throws UpdateException {
        dao.update(t);
    }
}
