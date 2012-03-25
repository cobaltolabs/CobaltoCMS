package com.cobaltolabs.cms.core.daos.mybatis;

import com.cobaltolabs.cms.core.IdBean;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 0:14
 */
public interface CmsMapper<I, T extends IdBean<I>> {
// -------------------------- OTHER METHODS --------------------------

    void delete(I id);
    List<T> findAll();

    T findById(I id);

    void insert(T t);

    void update(T t);
}
