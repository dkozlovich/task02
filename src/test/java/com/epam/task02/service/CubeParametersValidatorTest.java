package com.epam.task02.service;

import com.epam.task02.entity.Point;
import com.epam.task02.validator.CubeParametersValidator;
import com.epam.task02.validator.impl.CubeParametersValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CubeParametersValidatorTest {

    CubeParametersValidator cubeParametersValidator = CubeParametersValidatorImpl.getInstance();

    @Test
    public void validateCenterAndEdgeTest() {
        boolean result = cubeParametersValidator.isValidCenterAndEdgeString("10, -12.2189 - 3.11 36.88");
        Assert.assertTrue(result);
    }

    @Test
    public void validatePointsStringTest() {
        boolean result = cubeParametersValidator.isValidPointsString("12, -24, 38.8 - 49, 55, -86 - 77, 811.6, 2 - 1, 6, 9" +
                " - 1, 4, -3.8 - 4, 5, 86 - 7, 8.6, 3 - 1, 5, 9");
        Assert.assertTrue(result);
    }

    @Test
    public void isValidPointsTest() {
        Point p1 = new Point(0,0,0);
        Point p2 = new Point(1,0,0);
        Point p3 = new Point(1,1,0);
        Point p4 = new Point(0,1,0);
        Point p5 = new Point(0,0,1);
        Point p6 = new Point(1,0,1);
        Point p7 = new Point(1,1,1);
        Point p8 = new Point(0,1,1);
        List<Point> list = new ArrayList<>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
        boolean result = cubeParametersValidator.isValidPoints(list);
        Assert.assertTrue(result);
    }
}