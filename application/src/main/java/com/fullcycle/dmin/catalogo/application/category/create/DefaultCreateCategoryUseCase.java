package com.fullcycle.dmin.catalogo.application.category.create;

import com.fullcycle.dmin.catalogo.domain.category.domain.Category;
import com.fullcycle.dmin.catalogo.domain.category.domain.CategoryGateway;
import com.fullcycle.dmin.catalogo.domain.validation.handler.Notification;
import com.fullcycle.dmin.catalogo.domain.validation.handler.ThrowsValidationHandler;
import io.vavr.API;
import io.vavr.control.Either;

import java.util.Objects;

public class DefaultCreateCategoryUseCase extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public DefaultCreateCategoryUseCase(final CategoryGateway aCategoryGateway) {
        this.categoryGateway = Objects.requireNonNull(aCategoryGateway);
    }

    @Override
    public Either<Notification, CreateCategoryOutput> execute(final CreateCategoryCommand anIn) {
        final var aCategory = Category.newCategory(anIn.name(), anIn.description(), anIn.isActive());
        final var notification = Notification.create();
        aCategory.validate(new ThrowsValidationHandler());
        return notification.hasError() ? API.Left(notification) : create(aCategory);
    }

    private Either<Notification, CreateCategoryOutput> create(Category aCategory) {
        return API.Try(() -> this.categoryGateway.create(aCategory))
                .toEither()
                .bimap(Notification::create, CreateCategoryOutput::from);

    }
}
