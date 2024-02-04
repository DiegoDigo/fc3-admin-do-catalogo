package com.fullcycle.admin.catalogo.domain.exception;

import com.fullcycle.admin.catalogo.domain.validation.Error;

import java.util.List;

public class DomainException extends RuntimeException {

    private final List<Error> errors;

    private DomainException(final List<Error> anErrors) {
        super("", null, true, false);
        this.errors = anErrors;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public static DomainException with(final List<Error> anErros) {
        return new DomainException(anErros);
    }
}
