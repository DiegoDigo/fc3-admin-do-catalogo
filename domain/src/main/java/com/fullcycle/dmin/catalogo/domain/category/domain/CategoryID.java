package com.fullcycle.dmin.catalogo.domain.category.domain;

import com.fullcycle.dmin.catalogo.domain.Identifier;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
@EqualsAndHashCode(callSuper = true)
public class CategoryID extends Identifier {

    private final String value;

    private CategoryID(final String aValue) {
        Objects.requireNonNull(aValue, "'id' should not be null");
        this.value = aValue;
    }


    public static CategoryID unique() {
        return CategoryID.from(UUID.randomUUID());
    }

    public static CategoryID from(String anId) {
        return new CategoryID(anId);
    }

    public static CategoryID from(final UUID anId) {
        return new CategoryID(anId.toString().toLowerCase());
    }


}
