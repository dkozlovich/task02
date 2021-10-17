package com.epam.task02.repository.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.repository.CubeSpecification;

public class SurfaceAreaSpecification implements CubeSpecification {
    private double minSurfaceArea;
    private double maxSurfaceArea;

    public SurfaceAreaSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specify(Cube cube) {
        double surfaceArea = cube.getEdge();
        return surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea;
    }
}
