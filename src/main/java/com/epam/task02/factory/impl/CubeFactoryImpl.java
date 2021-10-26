package com.epam.task02.factory.impl;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.factory.CubeFactory;
import com.epam.task02.observer.CubeObserver;
import com.epam.task02.observer.impl.CubeObserverImpl;
import com.epam.task02.validator.CubeParametersValidator;
import com.epam.task02.validator.impl.CubeParametersValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CubeFactoryImpl implements CubeFactory {

    private static final int NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE = 4;

    private static CubeFactoryImpl instance;

    private CubeFactoryImpl() {

    }

    public static CubeFactory getInstance() {
        if (instance == null) {
            instance = new CubeFactoryImpl();
        }
        return instance;
    }

    private static final Logger logger = LogManager.getLogger();

    CubeParametersValidator cubeParametersValidator = CubeParametersValidatorImpl.getInstance();

    @Override
    public Cube createByPoints(List<Point> points) {
        CubeObserver cubeObserver = new CubeObserverImpl();
        Cube cube;
        double edge = 0;
        logger.info("Start calculating edge size via vertex points");
        if (cubeParametersValidator.isValidPoints(points)) {
            int xOfFirstPoint = (int) points.get(0).getX();
            List<Point> pointsAtFirstYOZCubeSideList = new ArrayList<>();
            for (int i = 0; i < points.size(); i++) {
                if (points.get(i).getX() == xOfFirstPoint) {
                    pointsAtFirstYOZCubeSideList.add(points.get(i));
                }
            }
            for (int i = 0; i < NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE; i++) {
                for (int j = 0; j < NUMBER_OF_POINTS_AT_ONE_CUBE_SIDE; j++) {
                    if (pointsAtFirstYOZCubeSideList.get(i).getY() == pointsAtFirstYOZCubeSideList.get(j).getY()
                            && pointsAtFirstYOZCubeSideList.get(i).getZ() != pointsAtFirstYOZCubeSideList.get(j).getZ()) {
                        edge = cubeParametersValidator.distanceBetween(pointsAtFirstYOZCubeSideList.get(i), pointsAtFirstYOZCubeSideList.get(j));
                    }
                }
            }
            logger.info("Edge size is " + edge);
        }
        logger.info("Start calculating center point via vertex points");
        double diagonal = edge * Math.sqrt(3);
        Point firstDiagonalPoint = points.get(0);
        Point secondDiagonalPoint = new Point();
        for (int i = 1; i < points.size(); i++) {
            if ((BigDecimal.valueOf(diagonal).setScale(2, RoundingMode.HALF_UP).doubleValue()
                    == BigDecimal.valueOf(cubeParametersValidator.distanceBetween(firstDiagonalPoint, points.get(i))).setScale(2, RoundingMode.HALF_UP).doubleValue())) {
                secondDiagonalPoint = points.get(i);
            }
        }
        Point center = new Point((firstDiagonalPoint.getX() + secondDiagonalPoint.getX()) / 2,  (firstDiagonalPoint.getY() + secondDiagonalPoint.getY()) / 2,
                (firstDiagonalPoint.getZ() + secondDiagonalPoint.getZ()) / 2);
        logger.info("Center point has coordinates: " + center);
        cube = new Cube(center, edge);
        cube.attach(cubeObserver);
        logger.info("Cube has been created");
        return cube;
    }

    @Override
    public Cube createByCenterAndEdge(Point center, double edge) {
        CubeObserver cubeObserver = new CubeObserverImpl();
        Cube cube = null;
        if (cubeParametersValidator.isValidCenterAndEdge(center, edge)) {
            cube = new Cube(center, edge);
            cube.attach(cubeObserver);
            logger.info("Cube has been created");
        }
        return cube;
    }
}
