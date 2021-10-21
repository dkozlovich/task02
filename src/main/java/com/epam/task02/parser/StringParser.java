package com.epam.task02.parser;

import com.epam.task02.entity.Point;

import java.util.List;

public interface StringParser {

    double[] parseToCenterAndEdge(String string);

    List<double[]> parseToCenterAndEdge(List<String> list);

    List<Point> parseToCubePoints(String string);

}
