package com.epam.task02.service;

import com.epam.task02.entity.Cube;
import com.epam.task02.entity.Point;
import com.epam.task02.factory.CubeFactory;
import com.epam.task02.service.impl.CubeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CubeServiceTest {

    private CubeService cubeService;

    @Before
    public void init() {
        cubeService = CubeServiceImpl.getInstance();
    }

    @Test
    public void testFindSurfaceArea() {
        double edge = 3;
        double expected = 54;
        Cube cube = CubeFactory.CreateCube(new Point(1,1,1),edge);
        double result = cubeService.findSurfaceArea(cube);
        Assert.assertEquals(expected,result,0.000001d);
    }

    @Test
    public void testFindVolume() {
        double edge = 3;
        double expected = 27;
        Cube cube = CubeFactory.CreateCube(new Point(1,1,1),edge);
        double result = cubeService.findVolume(cube);
        Assert.assertEquals(expected,result,0.000001d);
    }
}
