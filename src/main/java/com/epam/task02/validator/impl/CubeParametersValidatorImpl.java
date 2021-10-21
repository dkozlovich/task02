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

    private static final int POINTS_OF_ONE_CUBE_SIDE = 4;

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
        logger.info(String.format("Result of validation : %s. String: %s.", result, centerAndEdge));
        return result;
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
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).getX() == xOfFirstPoint) {
                pointsAtFirstYOZCubeSideList.add(points.get(i));
            }
        }
        if (pointsAtFirstYOZCubeSideList.size() != POINTS_OF_ONE_CUBE_SIDE) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }
        double edge = 0;
        for (int i = 0; i < POINTS_OF_ONE_CUBE_SIDE; i++) {
            for (int j = 0; j < POINTS_OF_ONE_CUBE_SIDE; j++) {
                if (pointsAtFirstYOZCubeSideList.get(i).getY() == pointsAtFirstYOZCubeSideList.get(j).getY()
                        && pointsAtFirstYOZCubeSideList.get(i).getZ() != pointsAtFirstYOZCubeSideList.get(j).getZ()) {
                    edge = distanceBetween(pointsAtFirstYOZCubeSideList.get(i), pointsAtFirstYOZCubeSideList.get(j));
                }
            }
        }
        int validPointOfYOZSide = 0;
        for (int i = 0; i < POINTS_OF_ONE_CUBE_SIDE; i++) {
            for (int j = 0; j < POINTS_OF_ONE_CUBE_SIDE; j++) {
                if (pointsAtFirstYOZCubeSideList.get(i).getY() == pointsAtFirstYOZCubeSideList.get(j).getY()
                        && pointsAtFirstYOZCubeSideList.get(i).getZ() != pointsAtFirstYOZCubeSideList.get(j).getZ()
                        && distanceBetween(pointsAtFirstYOZCubeSideList.get(i), pointsAtFirstYOZCubeSideList.get(j)) == edge) {
                    validPointOfYOZSide++;
                }
                if (pointsAtFirstYOZCubeSideList.get(i).getZ() == pointsAtFirstYOZCubeSideList.get(j).getZ()
                        && pointsAtFirstYOZCubeSideList.get(i).getY() != pointsAtFirstYOZCubeSideList.get(j).getY()
                        && distanceBetween(pointsAtFirstYOZCubeSideList.get(i), pointsAtFirstYOZCubeSideList.get(j)) == edge) {
                    validPointOfYOZSide++;
                }

            }
        }
        if (validPointOfYOZSide != POINTS_OF_ONE_CUBE_SIDE * 2) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }

        List<Point> pointsAtSecondYOZCubeSideList = new ArrayList<>(List.copyOf(points));
        pointsAtSecondYOZCubeSideList.removeAll(pointsAtFirstYOZCubeSideList);
        validPointOfYOZSide = 0;
        for (int i = 0; i < POINTS_OF_ONE_CUBE_SIDE; i++) {
            for (int j = 0; j < POINTS_OF_ONE_CUBE_SIDE; j++) {
                if (pointsAtSecondYOZCubeSideList.get(i).getY() == pointsAtSecondYOZCubeSideList.get(j).getY()
                        && pointsAtSecondYOZCubeSideList.get(i).getZ() != pointsAtSecondYOZCubeSideList.get(j).getZ()
                        && distanceBetween(pointsAtSecondYOZCubeSideList.get(i),pointsAtSecondYOZCubeSideList.get(j)) == edge) {
                    validPointOfYOZSide++;
                }
                if (pointsAtSecondYOZCubeSideList.get(i).getZ() == pointsAtSecondYOZCubeSideList.get(j).getZ()
                        && pointsAtSecondYOZCubeSideList.get(i).getY() != pointsAtSecondYOZCubeSideList.get(j).getY()
                        && distanceBetween(pointsAtSecondYOZCubeSideList.get(i),pointsAtSecondYOZCubeSideList.get(j)) == edge) {
                    validPointOfYOZSide++;
                }

            }
        }
        if (validPointOfYOZSide != POINTS_OF_ONE_CUBE_SIDE * 2) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }
        int edgesBetweenFirstAndSecond = 0;
        for (int i = 0; i < POINTS_OF_ONE_CUBE_SIDE; i++) {
            for (int j = 0; j < POINTS_OF_ONE_CUBE_SIDE; j++) {
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
        if (edgesBetweenFirstAndSecond != POINTS_OF_ONE_CUBE_SIDE) {
            logger.info(String.format("Result of validation : false. Points: %s. ", points));
            return false;
        }
        logger.info(String.format("Result of validation : true. Points: %s. ", points));
        return true;
    }

    private double distanceBetween(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2) + Math.pow(p1.getZ() - p2.getZ(), 2));
    }
}
