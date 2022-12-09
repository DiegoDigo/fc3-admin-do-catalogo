package com.fullcycle.dmin.catalogo.application.category.update;

import com.fullcycle.dmin.catalogo.application.UseCase;
import com.fullcycle.dmin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase
        extends UseCase<UpdateCategoryCommand, Either<Notification, UpdateCategoryOutput>> {
}
