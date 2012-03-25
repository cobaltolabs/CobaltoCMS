package com.cobaltolabs.cms.core;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Mario Arias
 *         Date: 23/02/12
 *         Time: 1:39
 */

public class InsertException extends Exception {
// --------------------------- CONSTRUCTORS ---------------------------

    public InsertException() {
    }

    public InsertException(String s) {
        super(s);
    }

    public InsertException(Throwable throwable) {
        super(throwable);
    }

    public InsertException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
