package com.fullcycle.dmin.catalogo.application.category.create;

import com.fullcycle.dmin.catalogo.domain.category.domain.Category;
import com.fullcycle.dmin.catalogo.domain.category.domain.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {

    public static CreateCategoryOutput from(final Category aCategory) {
        return new CreateCategoryOutput(aCategory.getId());
    }

}
