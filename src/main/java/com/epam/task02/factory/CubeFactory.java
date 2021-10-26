package com.epam.task02.factory;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;

import java.util.List;

public interface CubeFactory {

    Cube createByPoints(List<Point> points);

    Cube createByCenterAndEdge(Point center, double edge);

}
