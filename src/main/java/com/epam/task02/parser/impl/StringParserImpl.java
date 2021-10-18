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
    public double[] parseToCoordinatesAndEdge(String string) {

        if (cubeParametersValidator.isValid(string)) {
            String[] stringArray = string.split(DELIMITER_REGEX);
            double[] parameters = new double[stringArray.length];
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] = Double.parseDouble(stringArray[i]);
            }
            return parameters;
        }
        return null;
    }

//    @Override
//    public List<double[]> parseToCoordinatesAndEdge(List<String> list) {
//
//        List<double[]> listArray = new ArrayList<>();
//
//        for (int i = 0; i < list.size(); i++) {
//            if (cubeParametersValidator.isValid(list.get(i))) {
//                String[] stringArray = list.get(i).split(DELIMITER_REGEX);
//                double[] parameters = new double[stringArray.length];
//                for (int j = 0; j < parameters.length; j++) {
//                    parameters[j] = Double.parseDouble(stringArray[j]);
//                }
//                listArray.add(parameters);
//            }
//        }
//        return listArray;
//    }
//}

    @Override
    public List<double[]> parseToCoordinatesAndEdge(List<String> list) {

        List<double[]> listArray = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            double[] parameters = parseToCoordinatesAndEdge(list.get(i));
            if (parameters != null) {
                listArray.add(parameters);
            }
        }
        return listArray;
    }
}