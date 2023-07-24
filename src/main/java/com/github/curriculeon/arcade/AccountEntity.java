package com.github.curriculeon.arcade;

import com.github.curriculeon.utils.EntityInterface;

public class AccountEntity implements EntityInterface<Long> {
    private Long id;
    private String name;

    public AccountEntity() {
    }

    public AccountEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + "," + name + "\n";
    }
}
