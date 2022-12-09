package com.fullcycle.dmin.catalogo.domain.exceptions;

import com.fullcycle.dmin.catalogo.domain.validation.Errors;
import lombok.Getter;

import java.util.List;

@Getter
public class DomainException extends NoStacktraceException {

    private final List<Errors> errors;

    protected DomainException(final String message, List<Errors> anErrors) {
        super(message);
        this.errors = anErrors;
    }

    public static DomainException with(final List<Errors> anErrors) {
        return new DomainException("", anErrors);
    }

    public static DomainException with(Errors anError) {
        return new DomainException(anError.message(), List.of(anError));
    }
}
