package com.fullcycle.dmin.catalogo.domain.validation.handler;

import com.fullcycle.dmin.catalogo.domain.exceptions.DomainException;
import com.fullcycle.dmin.catalogo.domain.validation.Errors;
import com.fullcycle.dmin.catalogo.domain.validation.ValidationHandler;

import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<Errors> errors;

    private Notification(final List<Errors> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Throwable t) {
        return create(new Errors(t.getMessage()));
    }

    public static Notification create(final Errors anError) {
        return new Notification(new ArrayList<>()).append(anError);
    }

    @Override
    public Notification append(final Errors anError) {
        this.errors.add(anError);
        return this;
    }

    @Override
    public Notification append(final ValidationHandler anHandler) {
        this.errors.addAll(anHandler.getErrors());
        return this;
    }

    @Override
    public Notification validate(final Validation aValidation) {
        try {
             aValidation.validate();
        } catch (final DomainException ex) {
            this.errors.addAll(ex.getErrors());
        } catch (final Throwable t) {
            this.errors.add(new Errors(t.getMessage()));
        }
        return null;
    }

    @Override
    public List<Errors> getErrors() {
        return this.errors;
    }
}
