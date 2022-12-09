package com.fullcycle.dmin.catalogo.domain.exceptions;

import com.fullcycle.dmin.catalogo.domain.AggregateRoot;
import com.fullcycle.dmin.catalogo.domain.Identifier;
import com.fullcycle.dmin.catalogo.domain.validation.Errors;

import java.util.Collections;
import java.util.List;

public class NotFoundException extends DomainException {

    protected NotFoundException(final String aMessage, final List<Errors> anErrors) {
        super(aMessage, anErrors);
    }

    public static NotFoundException with(
            final Class<? extends AggregateRoot<?>> anAggregate,
            final Identifier id
    ) {
        final var anError = "%s with ID %s was not found".formatted(
                anAggregate.getSimpleName(),
                id.getValue()
        );
        return new NotFoundException(anError, Collections.emptyList());
    }
}
