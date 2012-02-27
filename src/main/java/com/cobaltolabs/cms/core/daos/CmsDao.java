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

    T find(I id) throws E;

    List<T> find();

    I insert(T t) throws InsertException;

    void delete(I id) throws DeleteException;

    void update(T t) throws UpdateException;
}
