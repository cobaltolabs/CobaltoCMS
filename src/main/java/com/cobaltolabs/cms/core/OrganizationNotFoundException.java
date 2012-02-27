package com.cobaltolabs.cms.core;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 22/02/12
 *         Time: 14:01
 */

public class OrganizationNotFoundException extends Exception {
// --------------------------- CONSTRUCTORS ---------------------------

    public OrganizationNotFoundException() {
    }

    public OrganizationNotFoundException(String s) {
        super(s);
    }

    public OrganizationNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public OrganizationNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
