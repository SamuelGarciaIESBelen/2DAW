package org.iesbelen.exception;

public class MiExcepcion extends Exception {
    private static final long serialVersionUID = 1L;

    public MiExcepcion() {
        super("{meError}");
    }
}
