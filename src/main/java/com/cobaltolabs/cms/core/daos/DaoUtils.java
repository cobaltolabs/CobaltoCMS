package com.cobaltolabs.cms.core.daos;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 0:11
 */

public final class DaoUtils {
// -------------------------- STATIC METHODS --------------------------

    public static <T, E extends Exception> T manageNull(T t, E e) throws E {
        if (t != null) {
            return t;
        } else {
            throw e;
        }
    }

// --------------------------- CONSTRUCTORS ---------------------------

    private DaoUtils() {
    }
}
