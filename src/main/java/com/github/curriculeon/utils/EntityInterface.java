package com.github.curriculeon.utils;

import java.io.Serializable;

public interface EntityInterface<IdType extends Serializable> {
    IdType getId();
}
