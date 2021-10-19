package com.epam.task02.parser;

import java.util.List;

public interface StringParser {

    double[] parseToCenterAndEdge(String string);

    List<double[]> parseToCenterAndEdge(List<String> list);

}
