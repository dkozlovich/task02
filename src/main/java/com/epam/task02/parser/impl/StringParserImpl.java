package com.epam.task02.parser.impl;

import com.epam.task02.parser.StringParser;
import com.epam.task02.validator.CubeParametersValidator;
import com.epam.task02.validator.impl.CubeParametersValidatorImpl;

import java.util.ArrayList;
import java.util.List;

public class StringParserImpl implements StringParser {

    private static final String DELIMITER_REGEX = ",\\s|\\s-\\s|\\s";

    CubeParametersValidator cubeParametersValidator = CubeParametersValidatorImpl.getInstance();

    @Override
    public double[] parseToCenterAndEdge(String string) {

        if (cubeParametersValidator.isValidCenterAndEdge(string)) {
            String[] stringArray = string.split(DELIMITER_REGEX);
            double[] parameters = new double[stringArray.length];
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] = Double.parseDouble(stringArray[i]);
            }
            return parameters;
        }
        return null;
    }

    @Override
    public List<double[]> parseToCenterAndEdge(List<String> list) {

        List<double[]> listArray = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            double[] parameters = parseToCenterAndEdge(list.get(i));
            if (parameters != null) {
                listArray.add(parameters);
            }
        }
        return listArray;
    }
}