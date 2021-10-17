package com.epam.task02.parser.impl;

import com.epam.task02.parser.StringParser;

public class StringParserImpl implements StringParser {

    private static final String DELIMITER_REGEX = ",\\s|\\s-\\s|\\s";

    @Override
    public double[] parseToCoordinatesAndEdge(String string) {

        String[] stringArray = string.split(DELIMITER_REGEX);
        double[] parameters = new double[stringArray.length];
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = Double.parseDouble(stringArray[i]);
        }
        return parameters;
    }
}