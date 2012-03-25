package com.cobaltolabs.cms.core.daos;

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
 *         Time: 0:07
 */
public interface CmsDao<I, T extends IdBean<I>, E extends Exception> {
// -------------------------- OTHER METHODS --------------------------

    void delete(I id) throws DeleteException;

    List<T> find();
    T find(I id) throws E;

    I insert(T t) throws InsertException;

    void update(T t) throws UpdateException;
}
