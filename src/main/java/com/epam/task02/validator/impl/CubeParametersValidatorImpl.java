package com.epam.task02.validator.impl;

import com.epam.task02.entity.Point;
import com.epam.task02.validator.CubeParametersValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeParametersValidatorImpl implements CubeParametersValidator {

    private static final String CENTER_AND_EDGE_REGEX = "(([+-]?([0-9]*[.])?[0-9]+(,\\s|\\s-\\s|\\s)){3})([0-9]*[.])?[0-9]*";

    private static final String POINTS_REGEX = "(([+-]?([0-9]*[.])?[0-9]+(,\\s|\\s-\\s|\\s)){7})([+-]?([0-9]*[.])?[0-9])";

    private static final int POINTS_ON_ONE_PLANE = 4;

    private static final Logger logger = LogManager.getLogger();

    private static CubeParametersValidator instance;

    private CubeParametersValidatorImpl() {

    }

    public static CubeParametersValidator getInstance() {
        if (instance == null) {
            instance = new CubeParametersValidatorImpl();
        }
        return instance;
    }

    @Override
    public boolean isValidCenterAndEdge(String centerAndEdge) {
        Pattern pattern = Pattern.compile(CENTER_AND_EDGE_REGEX);
        Matcher matcher = pattern.matcher(centerAndEdge);
        boolean result = matcher.matches();
        logger.info(String.format("String: %s. Result of validation : %s.", centerAndEdge, result));
        return result;
    }

    @Override
    public boolean isValidPointsString(String points) {
        Pattern pattern = Pattern.compile(POINTS_REGEX);
        Matcher matcher = pattern.matcher(points);
        boolean result = matcher.matches();
        if (!result) {
            logger.info(String.format("String: %s. Result of validation : false.", points));
            return false;
        }
        logger.info(String.format("String: %s. Result of validation : true.", points));
        return true;
    }

    @Override
    public boolean isValidPoints(List<Point> points) {
        long pointsOnXOYPlane = points.stream().filter(point -> point.getZ() == 0).count();
        long pointsOnXOZPlane = points.stream().filter(point -> point.getY() == 0).count();
        long pointsOnYOZPlane = points.stream().filter(point -> point.getX() == 0).count();
        if (pointsOnYOZPlane == POINTS_ON_ONE_PLANE || pointsOnXOZPlane == POINTS_ON_ONE_PLANE || pointsOnXOYPlane == POINTS_ON_ONE_PLANE) {
            return false;
        }
    }
}
