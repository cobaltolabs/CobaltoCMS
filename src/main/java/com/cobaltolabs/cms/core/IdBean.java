package com.cobaltolabs.cms.core;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 0:01
 */
public abstract class IdBean<T> {
// ------------------------------ FIELDS ------------------------------

    protected T id;

// --------------------- GETTER / SETTER METHODS ---------------------

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
