package com.cobaltolabs.cms.core.daos.impl;

import com.cobaltolabs.cms.core.DeleteException;
import com.cobaltolabs.cms.core.IdBean;
import com.cobaltolabs.cms.core.InsertException;
import com.cobaltolabs.cms.core.UpdateException;
import com.cobaltolabs.cms.core.daos.CmsDao;
import com.cobaltolabs.cms.core.daos.mybatis.CmsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 14:06
 */
public abstract class AbstractMyBatisCmsDao<I, T extends IdBean<I>, E extends Exception> implements CmsDao<I, T, E>, InitializingBean {
// ------------------------------ FIELDS ------------------------------

    private static final Logger log = LoggerFactory.getLogger(AbstractMyBatisCmsDao.class);
    protected CmsMapper<I, T> mapper;

// --------------------- GETTER / SETTER METHODS ---------------------

    @Required
    public void setMapper(CmsMapper<I, T> mapper) {
        this.mapper = mapper;
    }

// ------------------------ INTERFACE METHODS ------------------------


// --------------------- Interface CmsDao ---------------------


    @Override
    public void delete(I id) throws DeleteException {
        try {
            mapper.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw new DeleteException(e);
        }
    }

    @Override
    public List<T> find() {
        return mapper.findAll();
    }

    @Override
    public I insert(T t) throws InsertException {
        try {
            mapper.insert(t);
            return t.getId();
        } catch (DataIntegrityViolationException e) {
            log.error("Error inserting", e);
            throw new InsertException(e);
        }
    }

    @Override
    public void update(T t) throws UpdateException {
        try {
            mapper.update(t);
        } catch (DataIntegrityViolationException e) {
            throw new UpdateException(e);
        }
    }
}
