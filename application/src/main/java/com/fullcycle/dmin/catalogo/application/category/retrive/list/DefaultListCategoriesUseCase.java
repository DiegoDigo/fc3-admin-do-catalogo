package com.fullcycle.dmin.catalogo.application.category.retrive.list;

import com.fullcycle.dmin.catalogo.domain.category.domain.CategoryGateway;
import com.fullcycle.dmin.catalogo.domain.pagination.Pagination;
import com.fullcycle.dmin.catalogo.domain.pagination.SearchQuery;

import java.util.Objects;

public class DefaultListCategoriesUseCase extends ListCategoriesUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultListCategoriesUseCase(final CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Pagination<CategoryListOutput> execute(final SearchQuery aQuery) {
        return this.categoryGateway.findAll(aQuery)
                .map(CategoryListOutput::from);
    }
}