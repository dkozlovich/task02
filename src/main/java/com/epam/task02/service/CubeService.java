package com.epam.task02.service;

import com.epam.task02.entity.Cube;

public interface CubeService {

    double findSurfaceArea(Cube cube);

    double findVolume(Cube cube);

    double findDiagonal(Cube cube);

    boolean isShapeOnTheAxis(Cube cube);
}
