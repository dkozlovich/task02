package com.epam.task02.parser.impl;

import com.epam.task02.parser.StringParser;
import com.epam.task02.validator.CubeParametersValidator;
import com.epam.task02.validator.impl.CubeParametersValidatorImpl;

import java.util.stream.Stream;

public class StringParserImpl implements StringParser {

    private static final String DELIMITER_REGEX = ",\\s|\\s-\\s|\\s";

    @Override
    public double[] parseToCoordinatesAndEdge(String string) {

        String[] stringArray = string.split(DELIMITER_REGEX);
        double[] parameters;
        CubeParametersValidator cubeParametersValidator = new CubeParametersValidatorImpl();
        parameters = Stream.of(stringArray)
                .filter(s -> cubeParametersValidator.isValid(s))
                .mapToDouble(Double::parseDouble)
                .toArray();
        if (parameters.length != 4) {
            parameters = null;
        }
        return parameters;
    }
}
