package com.epam.task02.service;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.factory.CubeFactory;
import com.epam.task02.factory.impl.CubeFactoryImpl;
import com.epam.task02.service.impl.CubeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CubeServiceTest {

    private CubeService cubeService;

    private CubeFactory cubeFactory;

    @Before
    public void init() {
        cubeService = CubeServiceImpl.getInstance();
        cubeFactory = CubeFactoryImpl.getInstance();
    }

    @Test
    public void testFindSurfaceArea() {
        double edge = 3;
        double expected = 54;
        Cube cube = cubeFactory.createByCenterAndEdge(new Point(1,1,1),edge);
        double result = cubeService.findSurfaceArea(cube);
        Assert.assertEquals(expected, result,0.000001d);
    }

    @Test
    public void testFindVolume() {
        double edge = 3;
        double expected = 27;
        Cube cube = cubeFactory.createByCenterAndEdge(new Point(1,1,1),edge);
        double result = cubeService.findVolume(cube);
        Assert.assertEquals(expected, result,0.000001d);
    }

    @Test
    public void testFindDiagonal() {
        double edge = 5;
        double expected = 8.660254;
        Cube cube = cubeFactory.createByCenterAndEdge(new Point(1,1,1),edge);
        double result = cubeService.findDiagonal(cube);
        Assert.assertEquals(expected, result, 0.001d);
    }

    @Test
    public void testIsShapeOnTheAxis() {
        Cube cube = cubeFactory.createByCenterAndEdge(new Point(10,15,40),20);
        boolean result = cubeService.isShapeOnTheAxis(cube);
        Assert.assertTrue(result);
    }
}