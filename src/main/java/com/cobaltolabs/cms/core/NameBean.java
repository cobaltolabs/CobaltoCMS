package com.cobaltolabs.cms.core;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 0:03
 */
public abstract class NameBean<T> extends IdBean<T> {
// ------------------------------ FIELDS ------------------------------

    protected String name;

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
