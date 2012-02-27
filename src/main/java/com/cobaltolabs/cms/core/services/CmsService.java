package com.cobaltolabs.cms.core.services;

import com.cobaltolabs.cms.core.DeleteException;
import com.cobaltolabs.cms.core.IdBean;
import com.cobaltolabs.cms.core.InsertException;
import com.cobaltolabs.cms.core.UpdateException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 13:59
 */
public interface CmsService<I, T extends IdBean<I>, E extends Exception> {
// -------------------------- OTHER METHODS --------------------------

    void delete(T t) throws DeleteException;

    T get(I id) throws E;
    
    List<T> getAll();

    I insert(T t) throws InsertException;

    void update(T t) throws UpdateException;
}
