package com.github.curriculeon;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public interface FileRepositoryInterface<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>>
        extends RepositoryInterface<IdType, EntityType> {
    EntityType parse(String line);

    default ReadWriteFacade getReadWriteFacade() {
        final String fileName = getClass().getSimpleName();
        return DirectoryReference.RESOURCES.getReadWriteFacade("/" + fileName + ".csv");
    }

    @Override
    default List<EntityType> findAll() {
        return getReadWriteFacade()
                .toLines()
                .stream()
                .map(line -> {
                    try {
                        return parse(line);
                    } catch (Throwable t) {
                        return null;
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    default EntityType add(EntityType entity) {
        final IdType id = entity.getId();
        if (findById(id) != null) {
            final String errorMessage = "An entity with an id of [ %s ] already exists";
            throw new IllegalArgumentException(String.format(errorMessage, id));
        }
        getReadWriteFacade().write(entity.toString(), true);
        return findById(id);
    }

    @Override
    default EntityType delete(EntityType entity) {
        getReadWriteFacade().replaceAllOccurrences(entity.toString(), "");
        return findById(entity.getId());
    }

    @Override
    default EntityType updateById(IdType id, EntityType newData) {
        final EntityType accountToDelete = findById(id);
        getReadWriteFacade().replaceAllOccurrences(accountToDelete.toString(), newData.toString());
        return findById(id);
    }
}
