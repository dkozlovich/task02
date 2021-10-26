package com.epam.task02.service.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.service.CubeService;

public class CubeServiceImpl implements CubeService {

    private static CubeService instance;

    private CubeServiceImpl() {

    }

    public static CubeService getInstance() {
        if (instance == null) {
            instance = new CubeServiceImpl();
        }
        return instance;
    }

    @Override
    public double findSurfaceArea(Cube cube) {
        double square = 6 * Math.pow(cube.getEdge(),2);
        return square;
    }

    @Override
    public double findVolume(Cube cube) {
        double volume = Math.pow(cube.getEdge(),3);
        return volume;
    }

    @Override
    public double findDiagonal(Cube cube) {
        double diagonal = cube.getEdge() * Math.sqrt(3);
        return diagonal;
    }
}
