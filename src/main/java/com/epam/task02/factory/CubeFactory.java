package com.epam.task02.factory;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;

import java.util.List;

public class CubeFactory {

    public static Cube createByPoints(List<Point> points) {
        Cube cube = new Cube(points);
//        cube.setCenter();
//        cube.setEdge();
        return cube;
    }

    public static Cube CreateCube(Point center, double edge) {
        Cube cube = new Cube(center, edge);

//        cube.setPoints();
        return cube;
    }

}
