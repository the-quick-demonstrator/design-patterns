package com.github.curriculeon;

import java.io.Serializable;
import java.util.List;

public interface RepositoryInterface<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>> {
    List<EntityType> findAll();

    EntityType add(EntityType entityType);
    EntityType delete(EntityType entityType);

    EntityType updateById(IdType id, EntityType newData);
    default EntityType deleteById(IdType id) {
        return delete(findById(id));
    }
    default EntityType findById(IdType idOfEntityToFind) {
        return findAll()
                .stream()
                .filter(entity -> entity.getId() == idOfEntityToFind)
                .findFirst()
                .get();
    }
}
