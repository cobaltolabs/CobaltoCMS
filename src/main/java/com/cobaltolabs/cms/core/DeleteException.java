package com.cobaltolabs.cms.core;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 23/02/12
 *         Time: 18:05
 */
public class DeleteException extends Exception {
// --------------------------- CONSTRUCTORS ---------------------------

    public DeleteException() {
    }

    public DeleteException(String s) {
        super(s);
    }

    public DeleteException(Throwable throwable) {
        super(throwable);
    }

    public DeleteException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
