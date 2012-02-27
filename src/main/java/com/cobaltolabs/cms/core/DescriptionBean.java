package com.cobaltolabs.cms.core;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 0:04
 */
public abstract class DescriptionBean<T> extends NameBean<T> {
// ------------------------------ FIELDS ------------------------------

    private String description;

// --------------------- GETTER / SETTER METHODS ---------------------

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
