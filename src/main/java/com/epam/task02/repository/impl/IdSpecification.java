package com.epam.task02.repository.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.repository.CubeSpecification;

public class IdSpecification implements CubeSpecification {
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(Cube cube) {
        return id == cube.getCubeId();
    }
}
