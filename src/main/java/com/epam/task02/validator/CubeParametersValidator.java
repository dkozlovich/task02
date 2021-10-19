package com.epam.task02.validator;

import com.epam.task02.entity.Point;

import java.util.List;

public interface CubeParametersValidator {

    boolean isValidCenterAndEdge(String centerAndEdge);

    boolean isValidPointsString(String points);

    boolean isValidPoints(List<Point> points);
}
