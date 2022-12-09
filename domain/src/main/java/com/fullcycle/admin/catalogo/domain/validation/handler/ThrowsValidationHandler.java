package com.fullcycle.admin.catalogo.domain.validation.handler;

import com.fullcycle.admin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.admin.catalogo.domain.validation.Errors;
import com.fullcycle.admin.catalogo.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(Errors anErrors) {
        throw DomainException.with(anErrors);
    }

    @Override
    public ValidationHandler append(ValidationHandler aHandler) {
        throw DomainException.with(aHandler.getErrors());
    }

    @Override
    public ValidationHandler validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final Exception ex) {
            throw DomainException.with(List.of(new Errors(ex.getMessage())));
        }
        return this;
    }

    @Override
    public List<Errors> getErrors() {
        return List.of();
    }
}
