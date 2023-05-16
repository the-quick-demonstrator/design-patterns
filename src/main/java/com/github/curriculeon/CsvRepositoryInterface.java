package com.github.curriculeon;

import javax.swing.text.html.parser.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public interface CsvRepositoryInterface<
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
                .map(line -> parse(line) )
                .collect(Collectors.toList());
    }

    @Override
    default EntityType add(EntityType accountEntity) {
        final IdType id = accountEntity.getId();
        if (findById(id) != null) {
            final String errorMessage = "An account entity with an id of %s already exists";
            throw new IllegalArgumentException(String.format(errorMessage, id));
        }
        getReadWriteFacade().write(accountEntity.toString(), true);
        return findById(id);
    }

    @Override
    default EntityType delete(EntityType accountEntity) {
        getReadWriteFacade().replaceAllOccurrences(accountEntity.toString(), "");
        return findById(accountEntity.getId());
    }

    @Override
    default EntityType updateById(IdType id, EntityType newData) {
        final EntityType accountToDelete = findById(id);
        getReadWriteFacade().replaceAllOccurrences(accountToDelete.toString(), newData.toString());
        return findById(id);
    }
}
