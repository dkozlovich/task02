package com.epam.task02.service.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.service.CubeService;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
        return (BigDecimal.valueOf(diagonal).setScale(3, RoundingMode.HALF_UP).doubleValue());
    }

    @Override
    public boolean isShapeOnTheAxis(Cube cube) {
        Point center = cube.getCenter();
        double halfEdge = cube.getEdge() / 2;
        double x = BigDecimal.valueOf(center.getX()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        double y = BigDecimal.valueOf(center.getY()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        double z = BigDecimal.valueOf(center.getZ()).setScale(3, RoundingMode.HALF_UP).doubleValue();
        return (x - halfEdge) == 0 ||
                (x + halfEdge) == 0 ||
                (y - halfEdge) == 0 ||
                (y + halfEdge) == 0 ||
                (z - halfEdge) == 0 ||
                (z + halfEdge) == 0;
    }
}
