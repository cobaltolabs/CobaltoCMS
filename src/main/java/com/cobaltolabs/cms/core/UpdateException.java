package com.cobaltolabs.cms.core;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 26/02/12
 *         Time: 21:00
 */
public class UpdateException extends Exception{
// --------------------------- CONSTRUCTORS ---------------------------

    public UpdateException() {
    }

    public UpdateException(String s) {
        super(s);
    }

    public UpdateException(Throwable throwable) {
        super(throwable);
    }

    public UpdateException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
