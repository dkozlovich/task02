package com.epam.task02.repository.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.repository.CubeSpecification;

import java.math.BigDecimal;

public class EdgeSpecification implements CubeSpecification {
    private final double minEdge;
    private final double maxEdge;

    public EdgeSpecification(double minEdge, double maxEdge) {
        this.minEdge = minEdge;
        this.maxEdge = maxEdge;
    }

    @Override
    public boolean specify(Cube cube) {
        double edge = cube.getEdge();
        return minEdge <= edge && edge <= maxEdge;
    }

}
