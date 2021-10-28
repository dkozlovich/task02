package com.epam.task02.validator.impl;

import com.epam.task02.entity.Point;
import com.epam.task02.validator.CubeParametersValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeParametersValidatorImpl implements CubeParametersValidator {

    private static final String CENTER_AND_EDGE_REGEX = "(([+-]?([0-9]*[.])?[0-9]+(,\\s|\\s-\\s|\\s)){3})([0-9]*[.])?[0-9]*";

    private static final String POINTS_REGEX = "(([+-]?([0-9]*[.])?[0-9]+(,\\s|\\s-\\s|\\s)){23})([+-]?([0-9]*[.])?[0-9]+)";

    private static final Logger logger = LogManager.getLogger();

    private static final int NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE = 4;

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
    public boolean isValidCenterAndEdgeString(String centerAndEdge) {
        Pattern pattern = Pattern.compile(CENTER_AND_EDGE_REGEX);
        Matcher matcher = pattern.matcher(centerAndEdge);
        boolean result = matcher.matches();
        logger.info(String.format("Result of validation : %s. String: %s.", result, centerAndEdge));
        return result;
    }

    @Override
    public boolean isValidCenterAndEdge(Point center, double edge) {
        if (center != null && edge > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isValidPointsString(String points) {
        Pattern pattern = Pattern.compile(POINTS_REGEX);
        Matcher matcher = pattern.matcher(points);
        boolean result = matcher.matches();
        if (!result) {
            logger.info(String.format("Result of validation : false. String: %s. ", points));
            return false;
        }
        logger.info(String.format("Result of validation : true. String: %s.", points));
        return true;
    }

    @Override
    public boolean isValidPoints(List<Point> points) {
        int xOfFirstPoint = (int) points.get(0).getX();
        List<Point> pointsAtFirstYOZCubeSideList = new ArrayList<>();
        List<Point> pointsAtSecondYOZCubeSideList = new ArrayList<>();
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getX() == xOfFirstPoint) {
                pointsAtFirstYOZCubeSideList.add(points.get(i));
            } else {
                pointsAtSecondYOZCubeSideList.add(points.get(i));
            }
        }
        if (pointsAtFirstYOZCubeSideList.size() != NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE
                || pointsAtSecondYOZCubeSideList.size() != NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }
        double edge = calculateEdge(pointsAtFirstYOZCubeSideList);

        int validPointOfYOZSide = countValidPointOfOneCubeSide(pointsAtFirstYOZCubeSideList, edge);

        if (validPointOfYOZSide != NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }

        validPointOfYOZSide = countValidPointOfOneCubeSide(pointsAtSecondYOZCubeSideList, edge);

        if (validPointOfYOZSide != NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }
        int edgesBetweenFirstAndSecond = 0;
        for (int i = 0; i < NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE; i++) {
            for (int j = 0; j < NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE; j++) {
                if (distanceBetween(pointsAtFirstYOZCubeSideList.get(i), pointsAtSecondYOZCubeSideList.get(j)) == edge) {
                    edgesBetweenFirstAndSecond++;
                    if (pointsAtFirstYOZCubeSideList.get(i).getY() != pointsAtSecondYOZCubeSideList.get(j).getY()
                            || pointsAtFirstYOZCubeSideList.get(i).getZ() != pointsAtSecondYOZCubeSideList.get(j).getZ()) {
                        logger.info(String.format("Result of validation : false. Points: %s. ", points));
                        return false;
                    }
                }
            }
        }
        if (edgesBetweenFirstAndSecond != NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }
        logger.info(String.format("Result of validation : true. Points: %s. ", points));
        return true;
    }

    private double calculateEdge(List<Point> points) {
        double result = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (points.get(i).getY() == points.get(j).getY() && points.get(i).getZ() != points.get(j).getZ()) {
                    result = distanceBetween(points.get(i), points.get(j));
                }
            }
        }
        return result;
    }

    private int countValidPointOfOneCubeSide(List<Point> points, double edge) {
        int validPointOfYOZSide = 0;
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (points.get(i).getY() == points.get(j).getY() && points.get(i).getZ() != points.get(j).getZ()
                        && distanceBetween(points.get(i), points.get(j)) == edge) {
                    validPointOfYOZSide++;
                }
                if (points.get(i).getZ() == points.get(j).getZ() && points.get(i).getY() != points.get(j).getY()
                        && distanceBetween(points.get(i), points.get(j)) == edge) {
                    validPointOfYOZSide++;
                }

            }
        }
        return validPointOfYOZSide / 2;
    }

    public double distanceBetween(Point p1, Point point2) {
        return Math.sqrt(Math.pow(p1.getX() - point2.getX(), 2) + Math.pow(p1.getY() - point2.getY(), 2) + Math.pow(p1.getZ() - point2.getZ(), 2));
    }
}
