package com.epam.task02.factory;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;

public class CubeFactory {

    public static Cube CreateCube(Point center, double edge) {
        return new Cube(center,edge);
    }
}
