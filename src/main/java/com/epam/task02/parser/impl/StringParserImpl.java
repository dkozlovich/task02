package com.epam.task02.parser.impl;

import com.epam.task02.entity.Point;
import com.epam.task02.parser.StringParser;
import com.epam.task02.validator.CubeParametersValidator;
import com.epam.task02.validator.impl.CubeParametersValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StringParserImpl implements StringParser {

    private static final Logger logger = LogManager.getLogger();

    private static final String DELIMITER_REGEX = ",\\s|\\s-\\s|\\s";

    CubeParametersValidator cubeParametersValidator = CubeParametersValidatorImpl.getInstance();

    @Override
    public double[] parseToCenterAndEdge(String string) {

        if (cubeParametersValidator.isValidCenterAndEdgeString(string)) {
            String[] stringArray = string.split(DELIMITER_REGEX);
            double[] parameters = new double[stringArray.length];
            for (int i = 0; i < parameters.length; i++) {
                parameters[i] = Double.parseDouble(stringArray[i]);
            }
            logger.info(String.format("The string is correct. String: %s. ", string));
            return parameters;
        }
        logger.info(String.format("The string is incorrect. String: %s. ", string));
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
        if (listArray.size() != 0) {
            logger.info(String.format("Correct data is found in the list. List: %s. ", list));
        } else {
            logger.info(String.format("Valid string is not found. List: %s. ", list));

        }
        return listArray;
    }

    @Override
    public List<Point> parseToCubePoints(String string) {
        if (cubeParametersValidator.isValidPointsString(string)) {
            String[] stringArray = string.split(DELIMITER_REGEX);
            double[] doubleArray = new double[stringArray.length];
            for (int i = 0; i < doubleArray.length; i++) {
                doubleArray[i] = Double.parseDouble(stringArray[i]);
            }
            List<Point> points = new ArrayList<>();
            for(int i = 0; i < doubleArray.length; i = i + 3) {
                points.add(new Point(doubleArray[i], doubleArray[i + 1], doubleArray[i + 2]));
            }
            if (cubeParametersValidator.isValidPoints(points)) {
                logger.info(String.format("All points of the string are correct. String: %s. ", string));
                return points;
            }
        }
        logger.info(String.format("The string contains incorrect points. String: %s. ", string));
        return null;
    }
}