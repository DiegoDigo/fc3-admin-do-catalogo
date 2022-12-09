package com.fullcycle.dmin.catalogo.application.category.retrive.list;

import com.fullcycle.dmin.catalogo.application.UseCase;
import com.fullcycle.dmin.catalogo.domain.pagination.Pagination;
import com.fullcycle.dmin.catalogo.domain.pagination.SearchQuery;

public abstract class ListCategoriesUseCase
        extends UseCase<SearchQuery, Pagination<CategoryListOutput>> {
}
