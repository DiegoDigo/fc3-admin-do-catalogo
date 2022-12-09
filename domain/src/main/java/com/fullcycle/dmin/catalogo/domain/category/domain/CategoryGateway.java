package com.fullcycle.dmin.catalogo.domain.category.domain;

import com.fullcycle.dmin.catalogo.domain.pagination.SearchQuery;
import com.fullcycle.dmin.catalogo.domain.pagination.Pagination;

import java.util.Optional;

public interface CategoryGateway {

    Category create(Category aCategory);
    Category update(Category aCategory);
    void deleteById(CategoryID anId);
    Optional<Category> findById(CategoryID anId);
    Pagination<Category> findAll(SearchQuery aQuery);

}
