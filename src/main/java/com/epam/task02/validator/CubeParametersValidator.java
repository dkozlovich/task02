package com.epam.task02.validator;

import com.epam.task02.entity.Point;

import java.util.List;

public interface CubeParametersValidator {

    boolean isValidCenterAndEdgeString(String centerAndEdge);

    boolean isValidCenterAndEdge(Point center, double edge);

    boolean isValidPointsString(String points);

    boolean isValidPoints(List<Point> points);

    double distanceBetween(Point point1, Point point2);
}
