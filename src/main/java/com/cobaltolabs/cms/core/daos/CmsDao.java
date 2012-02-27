package com.cobaltolabs.cms.core.daos;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 0:07
 */
public interface CmsDao<I, T, E extends Exception> {
// -------------------------- OTHER METHODS --------------------------

    T find(I id) throws E;
}
