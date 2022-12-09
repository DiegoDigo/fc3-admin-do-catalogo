package com.fullcycle.admin.catalogo.domain.validation;

import java.util.List;

public interface ValidationHandler {


    ValidationHandler append(Errors anErrors);

    ValidationHandler append(ValidationHandler aHandler);

    ValidationHandler validate(Validation aValidation);

    List<Errors> getErrors();


    default Errors firstError() {
        if(hasError()) {
            return getErrors().get(0);
        }
        return null;
    }

    default boolean hasError() {
        return getErrors() != null && !getErrors().isEmpty();
    }

    public interface Validation {
        void validate();
    }
}
