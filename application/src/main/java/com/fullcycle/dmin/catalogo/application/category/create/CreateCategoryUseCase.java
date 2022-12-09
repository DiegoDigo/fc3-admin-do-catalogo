package com.fullcycle.dmin.catalogo.application.category.create;

import com.fullcycle.dmin.catalogo.application.UseCase;
import com.fullcycle.dmin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
