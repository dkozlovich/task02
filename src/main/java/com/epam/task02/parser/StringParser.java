package com.epam.task02.parser;

import java.util.List;

public interface StringParser {

    double[] parseToCoordinatesAndEdge(String string);

    List<double[]> parseToCoordinatesAndEdge(List<String> list);

}
