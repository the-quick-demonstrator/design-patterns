package com.github.curriculeon;

import java.io.Serializable;
import java.util.List;

public interface RepositoryLoggerInterface<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>>
        extends RepositoryInterface<IdType, EntityType> {
    RepositoryInterface<IdType, EntityType> getRepository();

    default InputOutputFacade getInputOutputFacade() {
        return new InputOutputFacade();
    }

    default void preInvokeLog(String method) {
        getInputOutputFacade().println("Attempting to perform [ %s.%s ]...", getClass().getSimpleName(), method);
    }

    default <SomeType> SomeType postInvokeLog(String method, SomeType result) {
        final String className = getClass().getSimpleName();
        final String resultString = result.toString().replaceAll("\n", "");
        getInputOutputFacade().println("[ %s.%s ] performed successfully!", className, method);
        getInputOutputFacade().println("[ %s.%s ] resulted in [ %s ]!", className, method, resultString);
        return result;
    }

    @Override
    default EntityType deleteById(IdType id) {
        preInvokeLog("deleteById");
        final EntityType entityToDelete = getRepository().findById(id);
        final EntityType result = getRepository().delete(entityToDelete);
        return postInvokeLog("deleteById", result);
    }

    @Override
    default EntityType findById(IdType idOfEntityToFind) {
        preInvokeLog("findById");
        final EntityType result = getRepository().findById(idOfEntityToFind);
        return postInvokeLog("findById", result);
    }

    @Override
    default List<EntityType> findAll() {
        preInvokeLog("findAll");
        final List<EntityType> result = getRepository().findAll();
        return postInvokeLog("findAll", result);
    }

    @Override
    default EntityType add(EntityType accountEntity) {
        preInvokeLog("add");
        final EntityType result = getRepository().add(accountEntity);
        return postInvokeLog("add", result);
    }

    @Override
    default EntityType delete(EntityType accountEntity) {
        preInvokeLog("delete");
        final EntityType result = getRepository().delete(accountEntity);
        return postInvokeLog("delete", result);
    }

    @Override
    default EntityType updateById(IdType id, EntityType newData) {
        preInvokeLog("updateById");
        final EntityType result = getRepository().updateById(id, newData);
        return postInvokeLog("updateById", result);
    }
}
